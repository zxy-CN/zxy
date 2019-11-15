package cn.his.services;

import cn.his.entity.CheckApply;
/**
 * 
 * @author 吴权鸿
 * time 2019-11-13
 */
public interface CheckApplyServices {
	
	/**
	 * 添加处置申请表
	 */
	int add(CheckApply checkApply);
	/**
	 * 修改处置申请表
	 */
	int update(CheckApply checkApply);
	/**
	 * 删除处置申请表
	 */
	int delete(int id);
	/**
	 * 查询处置申请表
	 */
	CheckApply query(int id);
}
