package cn.his.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.his.entity.DrugsDetailed;
import cn.his.entity.DrugsTemplate;
import cn.his.exception.CustomException;
import cn.his.services.DrugsDetailedServices;
import cn.his.services.DrugsTemplateServices;
/**
 * @author 吴权鸿
 * time 2019-11-14
 * 西药处方模板功能模块 包含获取药品模板,添加药品模板,修改药品模板,删除药品模板(逻辑删除)
 * 查询药品模板明细(id),添加药品模板明细,删除药品模板明细(物理删除)
 */
@Controller
@ResponseBody
@RequestMapping("/drugstemp")
public class DrugsTemplateController {
	@Autowired 
	private DrugsTemplateServices templateServices;//成药模板对象
	@Autowired
	private DrugsDetailedServices detailedServices;//成药模板明细对象
	
	private DrugsTemplate drugsTemplate; //处理空对象 即不带查询条件
	/**
	 * 根据模板名name 范围scope 查询所有模板信息
	 */
	@RequestMapping(value="/getall",method={RequestMethod.POST,RequestMethod.GET})
	public void getAllTemp(HttpServletResponse res,DrugsTemplate drugsTemplate) throws IOException{
		if(drugsTemplate==null) drugsTemplate = this.drugsTemplate;
		for(DrugsTemplate template : templateServices.getDrugsTemplates(drugsTemplate)){
			res.getWriter().print(JSON.toJSONString(template));
		}
	}
	/**
	 * 添加药品模板
	 */
	@RequestMapping(value={"/add"})
	public void addTemp(HttpServletResponse res,DrugsTemplate drugsTemplate) throws CustomException, IOException{
		if(drugsTemplate.getName()==null || drugsTemplate.getUserid()==null 
				|| drugsTemplate.getCreationtime()==null) return;
		templateServices.add(drugsTemplate);
		/*try {
			templateServices.add(drugsTemplate);			 			
		} catch (Exception e) {
			res.getWriter().print("药品模板信息有误,请重新添加");
		}*/
		
	}
	/**
	 * 修改药品模板
	 */
	@RequestMapping(value="/update")
	public void updateTemp(HttpServletResponse res,DrugsTemplate drugsTemplate){
		if(drugsTemplate==null || drugsTemplate.getId()==null) return;
		templateServices.update(drugsTemplate);
	}
	/**
	 * 删除药品模板 逻辑删除
	 */
	@RequestMapping(value="/delete",params={"id"})
	public void deleteTemp(Integer id){
		templateServices.delete(id);
	}
	/**
	 * 根据id获取药品模板明细
	 */
	@RequestMapping(value="/detail",method={RequestMethod.POST,RequestMethod.GET})
	public void drugsDetailed(HttpServletResponse res,Integer id) throws IOException{
		if(id == null) return;
		for(DrugsDetailed dd : detailedServices.getDrugsDetaileds(id)){
			res.getWriter().print(JSON.toJSONString(dd));
		}
	}
	/**
	 * 添加药品模板明细
	 */
	@RequestMapping(value={"/adddetail"})
	public void addDrugsTempDetail(HttpServletResponse res,DrugsDetailed drugsDetailed){
		if(drugsDetailed==null || drugsDetailed.getDrugstempid()==null || drugsDetailed.getDrugsid()==null) return;
		detailedServices.add(drugsDetailed);
	}
	/**
	 * 修改药品模板明细 
	 */
	@RequestMapping("/updatedetail")
	public void updateDetail(DrugsDetailed drugsDetailed){
		if(drugsDetailed==null || drugsDetailed.getDrugstempid()==null || drugsDetailed.getDrugsid()==null) return;
		detailedServices.update(drugsDetailed);
	}
	/**
	 * 删除药品模板明细 物理删除
	 */
	@RequestMapping("/deldetail")
	public void deleteDetail(Integer id){
		if(id==null) return;
		detailedServices.delete(id);
	}
	
}
