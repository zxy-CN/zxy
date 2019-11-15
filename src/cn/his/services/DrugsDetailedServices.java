package cn.his.services;

import java.util.ArrayList;

import cn.his.entity.DrugsDetailed;
/**
 * 
 * @author 吴权鸿
 * time 2019-11-13
 */
public interface DrugsDetailedServices {

	/**
	 * 添加成药处方模板明细表
	 */
	int add(DrugsDetailed drugsDetailed);
	/**
	 * 修改成药处方模板明细表
	 */
	int update(DrugsDetailed drugsDetailed);
	/**
	 * 删除成药处方模板明细表
	 */
	int delete(Integer id);
	/**
	 * 查询成药处方模板明细表 by id
	 */
	DrugsDetailed query(int id);
	
	/**
	 * 查询成药模板对应的所有明细
	 */
	ArrayList<DrugsDetailed> getDrugsDetaileds(Integer id);
}
