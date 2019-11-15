package cn.his.services;

import cn.his.entity.HerbalPrescription;
/**
 * 
 * @author 吴权鸿
 * time 2019-11-13
 */
public interface HerbalPrescriptionServices {

	/**
	 * 添加草药处方表
	 */
	int add(HerbalPrescription herbalPrescription);
	/**
	 * 修改草药处方表
	 */
	int update(HerbalPrescription herbalPrescription);
	/**
	 * 删除草药处方表
	 */
	int delete(int id);
	/**
	 * 查询草药处方表
	 */
	HerbalPrescription query(int id);
	
}
