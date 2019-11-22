package cn.his.controller;

import cn.his.entity.JsonResult;
import cn.his.entity.PatientCosts;
import cn.his.service.PatientCostsService;
import cn.his.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 费用查询控制器
 */
@RestController

public class PatientCostsController {

    @Autowired
    private PatientCostsService patientCostsService;
    @Autowired
    private RegisterService registerService;

    /**
     * 患者消费明细查询
     * @param request
     * @return
     */
    @RequestMapping(value="/get/costlist" ,method={RequestMethod.POST} )
    public JsonResult<ArrayList<PatientCosts>> getCostList(HttpServletRequest request){
        String caseNumber=request.getParameter("CaseNumber");
        String begin=request.getParameter("begin");
        String end=request.getParameter("end");
        HashMap<String,Object> map=new HashMap();
        //获得挂号id
        Integer id=registerService.getRegByCaseNumber(caseNumber).getId();
        map.put("id",id);
        map.put("begin",begin);
        map.put("end",end);
        ArrayList<PatientCosts> patientCosts=patientCostsService.selectByRegistID(map);
        if (patientCosts!=null){
            return new JsonResult<>("ok",patientCosts);
        }else {
            return new JsonResult<>("ondata",null);
        }
    }
}
