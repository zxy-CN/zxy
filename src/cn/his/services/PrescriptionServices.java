package cn.his.services;

import cn.his.entity.Prescription;

/**
 * 
 * @author 吴权鸿
 * time 2019-11-13
 */
public interface PrescriptionServices {
	
	/**
	 * 添加成药处方表
	 */
	int add(Prescription prescription);
	/**
	 * 修改成药处方表
	 */
	int update(Prescription prescription);
	/**
	 * 删除成药处方表
	 */
	int delete(int id);
	/**
	 * 查询成药处方表
	 */
	Prescription query(int id);
}
