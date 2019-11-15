package cn.his.services;

import cn.his.entity.PrescriptionDetailed;

/**
 * 
 * @author 吴权鸿
 * time 2019-11-13
 */
public interface PrescriptionDetailedServices {

	/**
	 * 添加成药处方表明细
	 */
	int add(PrescriptionDetailed prescriptionDetailed);
	/**
	 * 修改成药处方表明细
	 */
	int update(PrescriptionDetailed prescriptionDetailed);
	/**
	 * 删除成药处方表明细
	 */
	int delete(int id);
	/**
	 * 查询成药处方表明细
	 */
	PrescriptionDetailed query(int id);
	
}
