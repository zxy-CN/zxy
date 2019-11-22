package cn.his.controller;

import cn.his.entity.*;
import cn.his.service.CheckApplyService;
import cn.his.service.DepartmentService;
import cn.his.service.FmedItemService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 医技模块的控制器
 */
@RestController
public class CheckApplyController {
    @Autowired
    private CheckApplyService checkApplyService;
    @Autowired
    private FmedItemService fmedItemService;
    @Autowired
    private DepartmentService departmentService;

    /**
     * 点击处置时，拉取病人姓名列表
     * @return
     */
    @RequestMapping("/get/list")
    public JsonResult<ArrayList<CheckNameList>> getList(){
        ArrayList<CheckNameList> checkNameLists=checkApplyService.selectNameList();
        if (checkNameLists!=null){
            return new JsonResult<>("ok",checkNameLists);
        }
        return new JsonResult<>("err",null);
    }

    /**
     * 模糊查询
     * @param realName
     * @return
     */
    @RequestMapping("/select/listbyname")
    public JsonResult<ArrayList<CheckNameList>> getListByName(@RequestParam("RealName") String realName){
        ArrayList<CheckNameList> checkNameLists=checkApplyService.selectNameListByName(realName);
        if (checkNameLists!=null){
            return new JsonResult<>("ok",checkNameLists);
        }
        return new JsonResult<>("err",null);
    }

    /**
     * 根据病人对象查其项目
     * @param checkApply
     * @return
     */
    @RequestMapping("/select/items")
    public JsonResult<ArrayList<CheckApply>> getListByName(@RequestBody CheckApply checkApply){
        ArrayList<CheckApply> checkApplies=checkApplyService.selectItemByRegistId(checkApply);
        if (checkApplies!=null){
            return new JsonResult<>("ok",checkApplies);
        }
        return new JsonResult<>("err",null);
    }

    /**
     * 将处置状态改为已经检查
     * @param id
     * @return
     */
    @RequestMapping("/update/doapply")
    public JsonResult<Map> updateDoApply(@RequestParam("id") Integer id){
        int rs=checkApplyService.updateDoApply(id);
        if (rs!=0){
            return new JsonResult<>("ok",null);
        }
        return new JsonResult<>("err",null);
    }

    /**
     * 填写检查结果
     * @param id
     * @param result
     * @return
     */
    @RequestMapping("/update/result")
    public JsonResult<Map> updateResult(@RequestParam("id") Integer id,@RequestParam("result") String result){
        HashMap<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("result",result);
        int rs=checkApplyService.updateResult(map);
        if (rs!=0){
            return new JsonResult<>("ok",null);
        }
        return new JsonResult<>("err",null);
    }

    /**
     * 模糊分页查询
     * @param pageNum
     * @param itemName
     * @return
     */
    @RequestMapping("/get/page")
    public JsonResult<PageInfo<FmedItem>> getPage(@RequestParam("pageNum") Integer pageNum ,@RequestParam("itemName") String itemName){
        if (itemName==null){
            itemName=" ";
        }
        PageInfo<FmedItem> fmedItems=fmedItemService.findAll(pageNum,10,itemName);
        return new JsonResult<>("ok",fmedItems);
    }
    @RequestMapping("/get/addbase")
    public JsonResult<ArrayList<Department>> getBaseData(){
        ArrayList<Department> departments=departmentService.selectRegDept();
        if (departments!=null){
            return new JsonResult<>("ok",departments);
        }
        return new JsonResult<>("err",null);
    }
    /**
     * 添加处置
     * @param fmedItem
     * @return
     */
    @RequestMapping("/add/apply")
    public JsonResult<Map> addApply(@RequestBody FmedItem fmedItem){
        int rs=fmedItemService.insert(fmedItem);
        if (rs!=0){
            return new JsonResult<>("ok",null);
        }
        return new JsonResult<>("err",null);
    }

    /**
     * 修改
     * @param fmedItem
     * @return
     */
    @RequestMapping("/edit/apply")
    public JsonResult<Map> editApply(@RequestBody FmedItem fmedItem){
        int rs=fmedItemService.updateById(fmedItem);
        if (rs!=0){
            return new JsonResult<>("ok",null);
        }
        return new JsonResult<>("err",null);
    }

    /**
     * 删除
     * @param fmedItem
     * @return
     */
    @RequestMapping("/del/apply")
    public JsonResult<Map> delApply(@RequestBody FmedItem fmedItem){
        int rs=fmedItemService.deleteById(fmedItem);
        if (rs!=0){
            return new JsonResult<>("ok",null);
        }
        return new JsonResult<>("err",null);
    }


}
