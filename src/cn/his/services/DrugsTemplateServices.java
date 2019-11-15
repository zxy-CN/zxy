package cn.his.services;

import java.util.ArrayList;

import cn.his.entity.DrugsTemplate;
/**
 * 成药处方模板 西药处方模板
 * @author 吴权鸿
 * time 2019-11-13
 */
/**
 * 成药处方模板 西药处方模板
 * @author 吴权鸿
 * time 2019-11-13
 */
public interface DrugsTemplateServices {
	
	/**
	 * 添加成药处方模板
	 */
	int add(DrugsTemplate drugsTemplate);
	/**
	 * 修改成药处方模板
	 */
	int update(DrugsTemplate drugsTemplate);
	/**
	 * 删除成处方模板
	 */
	int delete(int id);
	/**
	 * 查询成药处方模板by id
	 */
	DrugsTemplate query(int id);
	/**
	 * 查询成药处方模板by name 模糊查询
	 */
	/*ArrayList<DrugsTemplate> getDrugsTemplatesByName(String name);*/
	/**
	 * 查询所有成药处方模板
	 * @return ArrayList<DrugsTemplate>
	 */
	ArrayList<DrugsTemplate> getDrugsTemplates(DrugsTemplate drugsTemplate);
	
	
	
}
