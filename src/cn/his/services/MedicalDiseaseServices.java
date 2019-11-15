package cn.his.services;

import cn.his.entity.MedicalDisease;
/**
 * 
 * @author 吴权鸿
 * time 2019-11-13
 */
public interface MedicalDiseaseServices {
	
	/**
	 * 添加患者诊断表
	 */
	int add(MedicalDisease disease);
	/**
	 * 删除患者诊断表
	 */
	int delete(int id);
	/**
	 * 修改患者诊断表
	 */
	int update(MedicalDisease disease);
	/**
	 * 查找患者诊断表
	 */
	MedicalDisease query(int id);
	
}
