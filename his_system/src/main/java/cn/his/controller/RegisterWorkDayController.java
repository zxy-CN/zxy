package cn.his.controller;

import cn.his.entity.Invoice;
import cn.his.entity.JsonResult;
import cn.his.entity.RegistWork;
import cn.his.entity.WorkSelect;
import cn.his.service.InvoiceService;
import cn.his.service.RegistWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日结控制器
 */
@RestController

public class RegisterWorkDayController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private RegistWorkService registWorkService;

    /**
     * 点击日结时从服务器拉取
     * @return
     */
    @RequestMapping("/get/endtime")
    public JsonResult<Map> getData(){
        HashMap<String,Object> map=new HashMap<>();
        String endTime=registWorkService.selectEndTime();
        if (endTime==null){
            //如果数据库是空的 就取当日九点为日结开始时间
            endTime=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString()+" 09:00:00";
        }
        map.put("endtime",endTime);
        return new JsonResult<>("ok",map);
    }

    /**
     * 选择收款员，日结时间后，取得数据，返回到前端
     * @param userId
     * @param begin
     * @param end
     * @return
     */
    @RequestMapping("/get/day")
    public JsonResult<Map> getInv(@RequestParam("userID") Integer userId,@RequestParam("begin") String begin,@RequestParam("end") String end){
        HashMap<String,Object> map1=new HashMap<>();
        map1.put("userId",userId);
        map1.put("begin",begin);
        map1.put("end",end);
        map1.put("dailyState",0);
        HashMap<String,Object> map=invoiceService.selectMaxAndMin(map1);
        if (map==null || map.size()==0){
            return new JsonResult<>("nodata",null);
        }
        //查作废的发票号
        ArrayList<String> delNumbers=invoiceService.selectDel(map1);
        //查重打的发票号
        ArrayList<String> againNumbers=invoiceService.selectAgain(map1);
        map.put("delNumbers",delNumbers);
        map.put("againNumbers",againNumbers);
        return  new JsonResult<>("ok",map);
    }
    @RequestMapping("/save/day")
    public JsonResult<Map> insertWork(@RequestBody RegistWork registWork){
        HashMap<String,Object> map1=new HashMap<>();
        map1.put("userId",registWork.getRegisterid());
        map1.put("begin",registWork.getStarttime());
        map1.put("end",registWork.getEndtime());
        int rs1=invoiceService.updateDailyState(map1);
        int rs=registWorkService.insert(registWork);
        if (rs==0){
            return  new JsonResult<>("exist",null);
        }
        return  new JsonResult<>("ok",null);
    }
    @RequestMapping("/select/works")
    public JsonResult<Map> getWorks(@RequestParam("begin") String begin,@RequestParam("end") String end){
        HashMap<String,Object> map1=new HashMap<>();
        map1.put("begin",begin);
        map1.put("end",end);
        ArrayList<WorkSelect> registWorks=registWorkService.selectAll(map1);
        HashMap<String,Object> map=new HashMap<>();
        map.put("registWorks",registWorks);
        if (registWorks!=null){
            return new JsonResult<>("ok",map);
        }
        return  new JsonResult<>("nodata",null);
    }
    //日结查询时，显示详细信息
    @RequestMapping("/select/detail")
    public JsonResult<Map> getWorksDetail(@RequestBody RegistWork registWork ){
        HashMap<String,Object> map1=new HashMap<>();
        map1.put("userId",registWork.getRegisterid());
        map1.put("begin",registWork.getStarttime());
        map1.put("end",registWork.getEndtime());
        map1.put("dailyState",1);
        HashMap<String,Object> map=invoiceService.selectMaxAndMin(map1);
        if (map==null || map.size()==0){
            return new JsonResult<>("nodata",null);
        }
        //查日结中每个病人的消费明细
        ArrayList<Invoice> invoices=invoiceService.selectlist(map1);
        //查作废的发票号
        ArrayList<String> delNumbers=invoiceService.selectDel(map1);
        //查重打的发票号
        ArrayList<String> againNumbers=invoiceService.selectAgain(map1);
        map.put("delNumbers",delNumbers);
        map.put("againNumbers",againNumbers);
        map.put("invoices",invoices);
        return  new JsonResult<>("ok",map);
    }
}
