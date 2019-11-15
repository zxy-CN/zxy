package cn.his.services;

import cn.his.entity.MedicalRecord;

/**
 * 
 * @author 吴权鸿
 * time 2019-11-13
 */
public interface MedicalRecordServices {

	/**
	 * 添加患者病历首页
	 */
	int addMedicalRecord(MedicalRecord medicalRecord);
	/**
	 * 修改患者病历首页
	 */
	int updateMedicalRecord(MedicalRecord medicalRecord);
	/**
	 * 删除患者病历首页
	 */
	int deleteMedicalRecord(int id);
	/**
	 * 查询患者病历首页
	 */
	MedicalRecord getMedicalRecord(int id);
	
}
