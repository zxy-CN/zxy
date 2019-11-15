package cn.his.services;

import java.util.ArrayList;

import cn.his.entity.CheckRelation;

/**
 * 
 * @author 吴权鸿
 * time 2019-11-13
 */
public interface CheckRelationServices {
	
	/**
	 * 添加处置申请模板明细
	 */
	int add(CheckRelation checkRelation);
	/**
	 * 修改处置申请模板明细
	 */
	int update(CheckRelation checkRelation);
	/**
	 * 删除处置申请模板明细
	 */
	int delete(Integer id);
	/**
	 * 查询处置申请模板明细
	 */
	ArrayList<CheckRelation> getCheckRelationsById(Integer id);
	
}
