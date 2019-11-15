package cn.his.controller;


import cn.his.entity.*;
import cn.his.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 病历的控制器
 */
@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private ConstatntltemService constatntltemService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private RegistLevelService registLevelService;
    @Autowired
    private UserService userService;
    @Autowired
    private SettleCategoryService settleCategoryService;
    @Autowired
    private InvoiceService invoiceService;

    //点击现场挂号后，要将性别，结算类别，挂号科室，号别，看诊医生，收费方式
    @RequestMapping(value="select/reg")
    public JsonResult<Map> getBase(){
        JsonResult<Map> result=null;
        HashMap<String, Object> map=new HashMap<>();
        //取常数数据,性别
        ArrayList<ConstatntItem> sex=constatntltemService.selectSex();
        //取常数项，收费方式
        ArrayList<ConstatntItem> MTC=constatntltemService.selectMTC();
        //取部门表，获得挂号科室
        ArrayList<Department> dept=departmentService.selectRegDept();
        //取挂号级别表，获得挂号级别
        ArrayList<RegistLevel> registLevels=registLevelService.selectRegLevel();
        //取用户表，获得看诊医生
        ArrayList<User> doc=userService.selectRegDoc();
        //取结算类别表，获得结算类别
        ArrayList<SettleCategory> sType=settleCategoryService.selectRegSType();
        //因为以上的表属于基础数据，不可能为空，所以不做判断
        //关于科室，挂号级别，医生三项，在前端用三级联动做判断
        map.put("stype",sType);
        map.put("sex",sex);
        map.put("MTC",MTC);
        map.put("dept",dept);
        map.put("levle",registLevels);
        map.put("doc",doc);
        return result=new JsonResult<>("ok",map);
    }


    //添加病历-挂号功能 （前端用json格式传递）
    @RequestMapping(value="add/reg")
    //这里我将挂号表和发票表的实体类封装到了一个新的实体类中
    //前台json传过来来个对象，分别是register对象和invoice对象
    //然后分别取到他们，进行操作
    public JsonResult<Register> addReg(@RequestBody RegAndInv regAndInv) {
        //1.取
        //2.调
        //这里先接收两个对象
        Register register=regAndInv.getRegister();
        Invoice invoice=regAndInv.getInvoice();
        int rs=registerService.addReg(register);
        JsonResult<Register> result=null;
        //如果增加成功，就将ok返回到前端
        if (rs != 0 ) {
            String caseNumber=register.getCasenumber();
            //这里需要根据病历号查出刚创建的挂号对象的id
            Register register1=registerService.getRegByCaseNumber(caseNumber);
            Integer id=register1.getId();
            //然后将发票对象的挂号id这一个属性与挂号表的对象关联
            invoice.setRegistid(id);
            //然后进行添加
            int rs1=invoiceService.insert(invoice);
            if (rs1!=0){
                result=new JsonResult<Register>("ok",null);
                return  result;
            }
        }
        result=new JsonResult<>("err",null);
        return result;
    }
    //改变病历状态-退号功能
    //首先要根据病历号查找病历
    //用注解取得传过来的病历号
    @RequestMapping(value="get/reg")
    public JsonResult<Register> getReg(@RequestParam("CaseNumber") String caseNumber){
        //2.调
        Register register=registerService.getRegByCaseNumber(caseNumber);
        JsonResult<Register> result=null;
       //3.转 如果查询到的病历不为空，将其返回到前端
        if(register!=null) {
            result = new JsonResult<Register>("ok", register);
            return result;
        }
        result=new JsonResult<>("err",null);
        return result;
    }
    //然后在前端点击操作-退号后，退号
    @RequestMapping(value="return/reg")
    public JsonResult<Register> returnReg(@RequestParam("CaseNumber") String caseNumber){
        //2.调用
        //先取到对象，这里不用判断对象是否存在，因为是点击退号按钮的，肯定存在
        Register register=registerService.getRegByCaseNumber(caseNumber);
        JsonResult<Register> result=null;
        //再更改其看诊状态
        int rs=registerService.returnReg(register);
        if (rs != 0) {
            result=new JsonResult<Register>("ok",null);
            return result;
        }
        result=new JsonResult<>("err",null);
        return result;
    }


//    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
// 测试连接用的查询
//    @RequestMapping("/reg/get/{ID}")
//    public @ResponseBody String getReg(@PathVariable("ID") Integer id){
//        Register register=registerService.getReg(id);
//        return "{\"ID\":\""+register.getId()+"\",\"RealName\":\""+register.getRealname()+"\"}";
//    }
//    @RequestMapping(value="add/reg",method={RequestMethod.POST})
//    public void addReg(HttpServletRequest request, HttpServletResponse response) throws ParseException {
//        //1.取
//        //取病历号
//        register.setCasenumber(request.getParameter("CaseNumber"));
//        //取患者姓名
//        register.setRealname(request.getParameter("RealName"));
//        //取性别，转成整型
//        String gender1=request.getParameter("Gender");
//        register.setGender(Integer.parseInt(gender1));
//        //取身份证
//        register.setIdnumber(request.getParameter("IDnumber"));
//        //出生日期
//        String birthDate1=request.getParameter("BirthDate");
//        register.setBirthdate(sdf.parse(birthDate1));
//        //取年龄
//        String age1=request.getParameter("Age");
//        register.setAge(Integer.parseInt(age1));
//        //年龄类型
//        register.setAgetype(request.getParameter("AgeType"));
//        //家庭住址
//        register.setHomeaddress(request.getParameter("HomeAddress"));
//        //本次看诊日期
//        String visitDate1=request.getParameter("VisitDate");
//        register.setVisitdate(sdf.parse(visitDate1));
//        //取午别
//        register.setNoon(request.getParameter("Noon"));
//        //取挂号科室id
//        String deptId1=request.getParameter("DeptID");
//        register.setDeptid(Integer.parseInt(deptId1));
//        //取挂号医生id
//        String userId1=request.getParameter("UserID");
//        register.setUserid(Integer.parseInt(userId1));
//        //取挂号级别id
//        String registLeId1=request.getParameter("RegistLeID");
//        register.setRegistleid(Integer.parseInt(registLeId1));
//        //取结算类别
//        String settleId1=request.getParameter("SettleID");
//        register.setSettleid(Integer.parseInt(settleId1));
//        //取是否要病历本
//        register.setIsbook(request.getParameter("IsBook"));
//        //取挂号时间
//        String registTime1=request.getParameter("RegistTime");
//        register.setRegisttime(sdf.parse(registTime1));
//        //取挂号员id
//        String registerId1=request.getParameter("RegisterID");
//        register.setRegisterid(Integer.parseInt(registerId1));
//        //取本此看诊状态
//        String visitState1=request.getParameter("VisitState");
//        Integer visitState=Integer.parseInt(visitState1);
//        register.setVisitstate(Integer.parseInt(visitState1));
//        //2.调
//        int rs=registerService.addReg(register);
//        System.out.println(rs);
//    }


}
