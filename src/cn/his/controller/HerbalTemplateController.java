package cn.his.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.his.entity.HerbalDetailed;
import cn.his.entity.HerbalTempDetailed;
import cn.his.entity.HerbalTemplate;
import cn.his.services.HerbalDetailedServices;
import cn.his.services.HerbalTempDetailedServices;
import cn.his.services.HerbalTemplateServices;

@Controller
@ResponseBody
@RequestMapping("/herbal")
public class HerbalTemplateController {
	@Autowired
	HerbalTemplateServices herbalTemplateServices;
	@Autowired
	private HerbalTempDetailedServices herbalTempDetailedServices;
	
	private HerbalTemplate herbalTemplate;
	/**
	 * 获取中药处方模板分页查询
	 * @param res
	 * @param herbalTemplate
	 * @throws IOException
	 */
	@RequestMapping(value = {"/templates"}, method = {RequestMethod.POST,RequestMethod.GET})
	public void getHerbalTemplates(HttpServletResponse res,HerbalTemplate herbalTemplate) throws IOException {
		if(herbalTemplate == null) herbalTemplate = this.herbalTemplate;
		for (HerbalTemplate ht : herbalTemplateServices.getHerbalTemplates(herbalTemplate)) {
			res.getWriter().print(JSON.toJSONString(ht));
		}
	}
	
	/**
	 * 添加中药处方模板
	 */
	@RequestMapping("/addtemp")
	public void addHerbTemp(HttpServletResponse res,HerbalTemplate herbalTemplate){
		if(herbalTemplate==null ||herbalTemplate.getName()==null || herbalTemplate.getDoctorid()==null) return;
		herbalTemplateServices.add(herbalTemplate);
	}
	
	
	/**
	 * 修改中药处方模板
	 */
	@RequestMapping("/updatetemp")
	public void updateHerbTemp(HttpServletResponse res,HerbalTemplate herbalTemplate){
		if(herbalTemplate==null ||herbalTemplate.getName()==null || herbalTemplate.getDoctorid()==null) return;
		herbalTemplateServices.update(herbalTemplate);
	}
	/**
	 * 删除中药处方模板
	 */
	@RequestMapping("/deltemp")
	public void delHerbTemp(HttpServletResponse res,Integer id){
		if(id==null) return;
		herbalTemplateServices.delete(id);
	}
	/**
	 * 添加中药处方模板明细
	 */
	@RequestMapping("/adddetail")
	public void addDetail(HttpServletResponse res,HerbalTempDetailed herbalTempDetailed){
		if(herbalTempDetailed==null || herbalTempDetailed.getHerbaltempid()==null || herbalTempDetailed.getHerbalid()==null) return;
		herbalTempDetailedServices.add(herbalTempDetailed);
	}
	/**
	 * 修改中药处方模板明细
	 */
	@RequestMapping("/updatedetail")
	public void updateDetail(HttpServletResponse res,HerbalTempDetailed herbalTempDetailed){
		if(herbalTempDetailed==null || herbalTempDetailed.getHerbaltempid()==null || herbalTempDetailed.getHerbalid()==null) return;
		herbalTempDetailedServices.update(herbalTempDetailed);
	}
	/**
	 * 查询中药处方模板明细
	 * @throws IOException 
	 */
	@RequestMapping("/getdetail")
	public void getDetail(HttpServletResponse res,Integer id) throws IOException{
		if(id==null) return;
		for(HerbalTempDetailed htd : herbalTempDetailedServices.getHerbalTempDetailedsById(id)){
			res.getWriter().print(JSON.toJSONString(htd));			
		}	
	}
	/**
	 * 删除中药中方模板明细
	 */
	@RequestMapping("/deldetail")
	public void delDetail(HttpServletResponse res,Integer id){
		if(id==null) return;
		herbalTempDetailedServices.delete(id);
	}
}
