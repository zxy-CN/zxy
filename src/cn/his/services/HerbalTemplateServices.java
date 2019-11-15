package cn.his.services;

import java.util.ArrayList;

import cn.his.entity.HerbalTemplate;
/**
 * 
 * @author 吴权鸿
 * time 2019-11-13
 */
public interface HerbalTemplateServices {
	
	/**
	 * 添加草药处方模板表
	 */
	int add(HerbalTemplate herbalTemplate);
	/**
	 * 修改草药处方模板表
	 */
	int update(HerbalTemplate herbalTemplate);
	/**
	 * 删除草药处方模板表
	 */
	int delete(Integer id);
	/**
	 * 查询草药处方模板表
	 */
	HerbalTemplate query(Integer id);
	
	/**
	 * 获取所有草药处方模板 根据name模糊查询,scope精确查询
	 */
	ArrayList<HerbalTemplate > getHerbalTemplates(HerbalTemplate herbalTemplate);
	
	/**
	 * 获取所有草药处方模板
	 */
	ArrayList<HerbalTemplate > getHerbalTemplates();
}
