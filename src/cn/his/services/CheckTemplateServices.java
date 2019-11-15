package cn.his.services;

import java.util.ArrayList;

import cn.his.entity.CheckTemplate;
/**
 * 
 * @author 吴权鸿
 * time 2019-11-13
 */
public interface CheckTemplateServices {

	/**
	 * 添加处置申请模板
	 */
	int add(CheckTemplate checkTemplate);
	/**
	 * 修改处置申请模板
	 */
	int update(CheckTemplate checkTemplate);
	/**
	 * 删除处置申请模板
	 */
	int delete(Integer id);
	/**
	 *查询处置申请模板 
	 */
	CheckTemplate query(Integer id);
	/**
	 * 获取所有处置模板
	 */
	ArrayList<CheckTemplate> getCheckTemplates(CheckTemplate checkTemplate);
	
}
