package cn.his.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.his.entity.CheckRelation;
import cn.his.entity.CheckTemplate;
import cn.his.services.CheckRelationServices;
import cn.his.services.CheckTemplateServices;
/**
 * 
 * @author 吴权鸿 医技管理模板 模块 医技模板增删改查(模糊查询) 模板明细增删改查
 */
@Controller
@ResponseBody
@RequestMapping("/check")
public class CheckApplyTemplateController {
	@Autowired
	CheckTemplateServices checkTemplateServices;
	@Autowired
	CheckRelationServices checkRelationServices;
	private CheckTemplate checkTemplate;
	/**
	 * 查询处置申请模板 查询关键字 名称,范围,记录类型
	 * @throws IOException 
	 */
	@RequestMapping("/gettemp")
	public void getTemp(HttpServletResponse res, CheckTemplate checkTemplate) throws IOException {
		if (checkTemplate.getName() == null && checkTemplate.getUserid() == null
				&& checkTemplate.getRecordtype() == null) checkTemplate = this.checkTemplate;		
		for(CheckTemplate c : checkTemplateServices.getCheckTemplates(checkTemplate)){
			res.getWriter().print(JSON.toJSONString(c));
		}
	}
	/**
	 * 添加处置申请模板
	 */
	@RequestMapping("/addtemp")
	public void addTemp(HttpServletResponse res, CheckTemplate checkTemplate) {
		if (checkTemplate.getName() == null
				|| checkTemplate.getUserid() == null
				|| checkTemplate.getRecordtype() == null
				|| checkTemplate.getCreationtime() == null)
			return;
		checkTemplateServices.add(checkTemplate);
	}
	/**
	 * 修改处置申请模板
	 */
	@RequestMapping("/updatetemp")
	public void updateTemp(HttpServletResponse res, CheckTemplate checkTemplate) {
		if (checkTemplate.getName() == null
				|| checkTemplate.getUserid() == null
				|| checkTemplate.getRecordtype() == null
				|| checkTemplate.getCreationtime() == null
				|| checkTemplate.getId() == null)
			return;
		checkTemplateServices.update(checkTemplate);
	}
	/**
	 * 删除处置申请模板 逻辑删除
	 */
	@RequestMapping("/deltemp")
	public void delTemp(HttpServletResponse res,Integer id) {
		if(id== null || id==0) return;
		checkTemplateServices.delete(id);
	}
	/**
	 * 查询处置申请模板明细 by id
	 * @throws IOException 
	 */
	@RequestMapping("/getdetail")
	public void getDetail(HttpServletResponse res,Integer id) throws IOException {
		if(id == null || id == 0) return;
		for(CheckRelation c : checkRelationServices.getCheckRelationsById(id)){
			res.getWriter().print(JSON.toJSONString(c));
		}
	}
	/**
	 * 添加处置申请模板明细
	 */
	@RequestMapping("/adddetail")
	public void addDetail(HttpServletResponse res,CheckRelation c) {
		if(c.getCheckprojid()==null || c.getChecktempid()==null) return;
		checkRelationServices.add(c);
	}
	/**
	 * 修改处置申请模板明细
	 */
	@RequestMapping("/updatedetail")
	public void updateDetail(HttpServletResponse res,CheckRelation c) {
		if(c.getCheckprojid()==null || c.getChecktempid()==null) return;
		checkRelationServices.update(c);
	}
	/**
	 * 删除处置申请模板明细 物理删除
	 */
	@RequestMapping("/deldetail")
	public void delDetail(HttpServletResponse res,Integer id) {
		if(id==null || id==0) return;
		checkRelationServices.delete(id);
	}
}
