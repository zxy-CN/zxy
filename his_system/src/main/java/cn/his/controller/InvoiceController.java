package cn.his.controller;

import cn.his.entity.Invoice;
import cn.his.entity.JsonResult;
import cn.his.entity.Register;
import cn.his.service.InvoiceService;
import cn.his.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 发票打印模块的控制器
 */
@RestController
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private RegisterService registerService;
    @RequestMapping("/get/inv")
    public JsonResult<Map> getInv(@RequestParam("CaseNumber") String caseNumber){
        HashMap<String,Object> map=new HashMap<>();
        //先根据病历号查到挂号对象
        Register register=registerService.getRegByCaseNumber(caseNumber);
        if (register==null){
            return new JsonResult<>("nodata",null);
        }
        //根据挂号id查到发票
        Invoice invoice=invoiceService.selectByRegistID(register.getId());
        if (invoice==null){
            return new JsonResult<>("nodata",null);
        }
        map.put("register",register);
        map.put("invoice",invoice);
        return new JsonResult<>("ok",map);
    }

    /**
     * 发票重打
     * @param registid
     * @return
     */
    @RequestMapping("/re/print")
    public JsonResult<Map> updateState5(@RequestParam("registid") Integer registid){
        Invoice invoice=invoiceService.selectByRegistID(registid);
        if (invoice==null){
            return new JsonResult<>("err",null);
        }
        int rs=invoiceService.updateState5(invoice);
        if (rs!=0){
            return new JsonResult<>("ok",null);
        }
        return new JsonResult<>("err",null);
    }
    /**
     * 发票重打
     * @param registid
     * @return
     */
    @RequestMapping("/ag/print")
    public JsonResult<Map> updateState6(@RequestParam("registid") Integer registid){
        Invoice invoice=invoiceService.selectByRegistID(registid);
        if (invoice==null){
            return new JsonResult<>("err",null);
        }
        int rs=invoiceService.updateState6(invoice);
        if (rs!=0){
            return new JsonResult<>("ok",null);
        }
        return new JsonResult<>("err",null);
    }
}
