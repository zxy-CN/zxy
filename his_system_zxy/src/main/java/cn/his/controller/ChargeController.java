package cn.his.controller;


import cn.his.entity.JsonResult;
import cn.his.entity.VChargeCapply;
import cn.his.entity.VChargeHerbal;
import cn.his.entity.VChargePrescription;
import cn.his.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 收费控制器
 */
@RestController
public class ChargeController {
    @Autowired
    private VChargeCapplyService vChargeCapplyService;
    @Autowired
    private VChargeHerBalService vChargeHerBalService;
    @Autowired
    private VChargePrescriptionService vChargePrescriptionService;
    @Autowired
    private CheckApplyService checkApplyService;
    @Autowired
    private HerbalPrescriptionService herbalPrescriptionService;
    @Autowired
    private PrescriptionDetailedService prescriptionDetailedService;
    /**
     * 收费时查询消费项目明细
     */
    @RequestMapping(value="get/cost")
    public JsonResult<Map> getCost(@RequestParam("CaseNumber") String caseNumber){
        JsonResult<Map> result=null;
        HashMap<String, Object> map=new HashMap<>();
        //2.调用
        //查非药项目
        ArrayList<VChargeCapply> vChargeCapplies=vChargeCapplyService.getCapply(caseNumber);
        //查草药项目
        ArrayList<VChargeHerbal> vChargeHerbals=vChargeHerBalService.getHerBal(caseNumber);
        //查成药项目
        ArrayList<VChargePrescription> vChargePrescriptions=vChargePrescriptionService.getPrescription(caseNumber);
        //要是三个项目不为空，就添加到map中发送到前端
        if (vChargeCapplies.size()!=0){
            map.put("vChargeCapplies",vChargeCapplies);
        }
        if (vChargeHerbals.size()!=0){
            map.put("vChargeHerbals",vChargeHerbals);
        }
        if (vChargePrescriptions.size()!=0){
            map.put("vChargePrescriptions",vChargePrescriptions);
        }
        //如果每个项目都为空，则想前端返回没有数据
        if (vChargeCapplies.size()==0 && vChargeHerbals.size()==0 && vChargePrescriptions.size()==0){
            return result=new JsonResult<>("nodata",null);
        }
        return result=new JsonResult<>("ok",map);
    }
    /**
     * 缴费
     */
    @RequestMapping(value="update/cost")
    public JsonResult<Map> updateCost(HttpServletRequest request){
        JsonResult<Map> result=null;
        //点击缴费后，将相应的id传过来，因为有处置项目的c_id，成药项目p_id，草药项目h_id，所以不能用注解，因为每次只会传过来一个
        String c_id1=request.getParameter("c_id");
        String h_id1=request.getParameter("h_id");
        String p_id1=request.getParameter("p_id");
        if (c_id1!=null && c_id1.equals("")==false){
            Integer c_id=Integer.parseInt(c_id1);
            int rs=checkApplyService.updateState(c_id);
            if (rs!=0){
                return result=new JsonResult<>("ok",null);
            }else {
                return result=new JsonResult<>("err",null);
            }
        }
        if (h_id1!=null && h_id1.equals("")==false){
            Integer h_id=Integer.parseInt(h_id1);
            int rs=herbalPrescriptionService.updateState(h_id);
            if (rs!=0){
                return result=new JsonResult<>("ok",null);
            }else {
                return result=new JsonResult<>("err",null);
            }
        }
        if (p_id1!=null && p_id1.equals("")==false){
            Integer p_id=Integer.parseInt(p_id1);
            int rs=prescriptionDetailedService.updateState(p_id);
            if (rs!=0){
                return result=new JsonResult<>("ok",null);
            }else {
                return result=new JsonResult<>("err",null);
            }
        }
        return result=new JsonResult<>("err",null);
    }
}
