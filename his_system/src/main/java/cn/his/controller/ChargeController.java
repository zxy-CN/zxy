package cn.his.controller;


import cn.his.entity.*;
import cn.his.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private RegisterService registerService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private PatientCostsService patientCostsService;
    /**
     * 收费时查询消费项目明细，由state判断是缴费还是退费，由前端根据数字判断
     * 2-已开立
     * 3-已交费
     * 4-已发药
     * 5-已退药
     * 6-已退费
     */
    @RequestMapping(value="/get/cost")
    public JsonResult<Map> getCost(@RequestParam("CaseNumber") String caseNumber){
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
            return new JsonResult<>("nodata",null);
        }
        return new JsonResult<>("ok",map);
    }

    /**
     * 缴费
     * @param request
     * @return
     */
    @RequestMapping(value="/update/cost")
    public JsonResult<Map> updateCost(HttpServletRequest request){
        //点击缴费后，将相应的id传过来，因为有处置项目的c_id，成药项目p_id，草药项目h_id，所以不能用注解，因为每次只会传过来一个
        String c_id1=request.getParameter("c_id");
        String h_id1=request.getParameter("h_id");
        String p_id1=request.getParameter("p_id");
        String caseNumber=request.getParameter("CaseNumber");
        //这个应该是用session取，这里测试先这样写
        String registerId1=request.getParameter("registerId");
        Integer registerId=Integer.parseInt(registerId1);
        //先用病历号查到挂号id
        Integer registId=registerService.getRegByCaseNumber(caseNumber).getId();
        //再用挂号id查到发票id
        //查到这个发票对象
        Invoice invoice=invoiceService.selectByRegistID(registId);
        Integer invoiceId=invoice.getId();
        //收费方式
        Integer FeeType=invoiceService.selectByRegistID(registId).getFeetype();
        //处置部分
        if (c_id1!=null && c_id1.equals("")==false){
            Integer c_id=Integer.parseInt(c_id1);
            //更改项目状态
            int rs=checkApplyService.updateState(c_id);
        //最后用c_id查处置视图
            VChargeCapply vChargeCapply=vChargeCapplyService.selectByID(c_id);
            //项目名
            String name=vChargeCapply.getItemname();
            //项目单价
            BigDecimal price=vChargeCapply.getPrice();
            //项目数量
            BigDecimal Amount= BigDecimal.valueOf(vChargeCapply.getNum());
            //执行科室id
            Integer DeptID=vChargeCapply.getDeptid();
            //开立时间
            Date Createtime=vChargeCapply.getCreationtime();
            //开立人员id
            Integer CreateOperID=vChargeCapply.getDoctorid();
            PatientCosts patientCosts=new PatientCosts(registId,invoiceId,c_id,1,name,price,Amount,DeptID,Createtime,CreateOperID,registerId,FeeType,null);
            int rs1=patientCostsService.insertCApply(patientCosts);
            //动态修改发票中的消费金额
            BigDecimal money=invoice.getMoney().add(price.multiply(Amount));
            invoice.setMoney(money);
            //缴费时打印发票，所以将发票的状态改为4，已打印（创建时虽然交了挂号费，但未打印发票，所以状态为3）
            int rs2=invoiceService.updateMoney(invoice);
            if (rs!=0 && rs1!=0 && rs2!=0){
                return new JsonResult<>("ok",null);
            }else {
                return new JsonResult<>("err",null);
            }
        }
        //草药部分
        if (h_id1!=null && h_id1.equals("")==false){
            Integer h_id=Integer.parseInt(h_id1);
            int rs=herbalPrescriptionService.updateState(h_id);
            VChargeHerbal vChargeHerbal=vChargeHerBalService.selectByID(h_id);
            //项目名
            String name=vChargeHerbal.getDrugsname();
            //项目单价
            BigDecimal price=vChargeHerbal.getDrugsprice();
            //项目数量
            String Dosage1=vChargeHerbal.getDosage();
            Integer Dosage2=Integer.parseInt(Dosage1);
            BigDecimal Amount=BigDecimal.valueOf(Dosage2);
            //开立人员
            Integer CreateOperID=vChargeHerbal.getDoctorid();
            //开立时间
            Date Createtime=vChargeHerbal.getCreationtime();
            PatientCosts patientCosts=new PatientCosts(registId,invoiceId,h_id,2,name,price,Amount,132,Createtime,CreateOperID,registerId,FeeType,null);
            int rs1=patientCostsService.insertMid(patientCosts);
            //动态修改发票中的消费金额
            BigDecimal money=invoice.getMoney().add(price.multiply(Amount));
            invoice.setMoney(money);
            int rs2=invoiceService.updateMoney(invoice);
            if (rs!=0 && rs1!=0 && rs2!=0){
                return new JsonResult<>("ok",null);
            }else {
                return new JsonResult<>("err",null);
            }
        }
        //成药部分
        if (p_id1!=null && p_id1.equals("")==false){
            Integer p_id=Integer.parseInt(p_id1);
            int rs=prescriptionDetailedService.updateState(p_id);
            VChargePrescription vChargePrescription=vChargePrescriptionService.selectByID(p_id);
            //项目名
            String name=vChargePrescription.getDrugsname();
            //项目单价
            BigDecimal price=vChargePrescription.getDrugsprice();
            //项目数量
            String Dosage1=vChargePrescription.getDosage();
            Integer Dosage2=Integer.parseInt(Dosage1);
            BigDecimal Amount=BigDecimal.valueOf(Dosage2);
            //开立人员
            Integer CreateOperID=vChargePrescription.getUserid();
            //开立时间
            Date Createtime=vChargePrescription.getPrescriptiontime();
            PatientCosts patientCosts=new PatientCosts(registId,invoiceId,p_id,2,name,price,Amount,132,Createtime,CreateOperID,registerId,FeeType,null);
            int rs1=patientCostsService.insertMid(patientCosts);
            //动态修改发票中的消费金额
            BigDecimal money=invoice.getMoney().add(price.multiply(Amount));
            invoice.setMoney(money);
            int rs2=invoiceService.updateMoney(invoice);
            if (rs!=0 && rs1!=0 && rs2!=0){
                return new JsonResult<>("ok",null);
            }else {
                return new JsonResult<>("err",null);
            }
        }
        return new JsonResult<>("err",null);
    }

    /**
     * 与缴费的方法一致，只是改变了状态，以及在清单里添加了退费记录id，再前端，若backid不为空，则为已退费的项目
     * @param request
     * @return
     */
    @RequestMapping(value="/return/cost")
    public JsonResult<Map> returnCost(HttpServletRequest request){
        //点击缴费后，将相应的id传过来，因为有处置项目的c_id，成药项目p_id，草药项目h_id，所以不能用注解，因为每次只会传过来一个
        String c_id1=request.getParameter("c_id");
        String h_id1=request.getParameter("h_id");
        String p_id1=request.getParameter("p_id");
        String caseNumber=request.getParameter("CaseNumber");
        //这个应该是用session取，这里测试先这样写
        String registerId1=request.getParameter("registerId");
        Integer registerId=Integer.parseInt(registerId1);
        //先用病历号查到挂号id
        Integer registId=registerService.getRegByCaseNumber(caseNumber).getId();
        //再用挂号id查到发票id
        Integer invoiceId=invoiceService.selectByRegistID(registId).getId();
        //收费方式
        Integer FeeType=invoiceService.selectByRegistID(registId).getFeetype();
        //处置部分
        if (c_id1!=null && c_id1.equals("")==false){
            Integer c_id=Integer.parseInt(c_id1);
            int rs=checkApplyService.returnCost(c_id);
            //最后用c_id查处置视图
            VChargeCapply vChargeCapply=vChargeCapplyService.selectByID(c_id);
            //项目名
            String name=vChargeCapply.getItemname();
            //项目单价
            BigDecimal price=vChargeCapply.getPrice();
            //项目数量
            BigDecimal Amount= BigDecimal.valueOf(vChargeCapply.getNum());
            //执行科室id
            Integer DeptID=vChargeCapply.getDeptid();
            //开立时间
            Date Createtime=vChargeCapply.getCreationtime();
            //开立人员id
            Integer CreateOperID=vChargeCapply.getDoctorid();
            PatientCosts patientCosts=new PatientCosts(registId,invoiceId,c_id,1,name,price,Amount,DeptID,Createtime,CreateOperID,registerId,FeeType,c_id);
            int rs1=patientCostsService.insertCApply(patientCosts);
            if (rs!=0 && rs1!=0){
                return new JsonResult<>("ok",null);
            }else {
                return new JsonResult<>("err",null);
            }
        }
        //草药部分
        if (h_id1!=null && h_id1.equals("")==false){
            Integer h_id=Integer.parseInt(h_id1);
            int rs=herbalPrescriptionService.returnCost(h_id);
            VChargeHerbal vChargeHerbal=vChargeHerBalService.selectByID(h_id);
            //项目名
            String name=vChargeHerbal.getDrugsname();
            //项目单价
            BigDecimal price=vChargeHerbal.getDrugsprice();
            //项目数量
            String Dosage1=vChargeHerbal.getDosage();
            Integer Dosage2=Integer.parseInt(Dosage1);
            BigDecimal Amount=BigDecimal.valueOf(Dosage2);
            //开立人员
            Integer CreateOperID=vChargeHerbal.getDoctorid();
            //开立时间
            Date Createtime=vChargeHerbal.getCreationtime();
            PatientCosts patientCosts=new PatientCosts(registId,invoiceId,h_id,2,name,price,Amount,132,Createtime,CreateOperID,registerId,FeeType,h_id);
            int rs1=patientCostsService.insertMid(patientCosts);
            if (rs!=0 && rs1!=0){
                return new JsonResult<>("ok",null);
            }else {
                return new JsonResult<>("err",null);
            }
        }
        //成药部分
        if (p_id1!=null && p_id1.equals("")==false){
            Integer p_id=Integer.parseInt(p_id1);
            int rs=prescriptionDetailedService.retrunCost(p_id);
            VChargePrescription vChargePrescription=vChargePrescriptionService.selectByID(p_id);
            //项目名
            String name=vChargePrescription.getDrugsname();
            //项目单价
            BigDecimal price=vChargePrescription.getDrugsprice();
            //项目数量
            String Dosage1=vChargePrescription.getDosage();
            Integer Dosage2=Integer.parseInt(Dosage1);
            BigDecimal Amount=BigDecimal.valueOf(Dosage2);
            //开立人员
            Integer CreateOperID=vChargePrescription.getUserid();
            //开立时间
            Date Createtime=vChargePrescription.getPrescriptiontime();
            PatientCosts patientCosts=new PatientCosts(registId,invoiceId,p_id,2,name,price,Amount,132,Createtime,CreateOperID,registerId,FeeType,p_id);
            int rs1=patientCostsService.insertMid(patientCosts);
            if (rs!=0){
                return new JsonResult<>("ok",null);
            }else {
                return new JsonResult<>("err",null);
            }
        }
        return new JsonResult<>("err",null);
    }
}
