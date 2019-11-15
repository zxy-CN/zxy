package cn.his.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.his.entity.MedicalRecord;
import cn.his.mapper.MedicalRecordMapper;
import cn.his.services.MedicalRecordServices;
@Service
public class MedicalRecordServicesImpl implements MedicalRecordServices{
	@Autowired
	private MedicalRecordMapper mapper;
	public int addMedicalRecord(MedicalRecord medicalRecord) {
		
		return mapper.insert(medicalRecord);
	}

	public int updateMedicalRecord(MedicalRecord medicalRecord) {
		
		return mapper.updateByPrimaryKeySelective(medicalRecord);
	}

	public int deleteMedicalRecord(int id) {
		
		return mapper.deleteByPrimaryKey(id);
	}

	public MedicalRecord getMedicalRecord(int id) {
		
		return mapper.selectByPrimaryKey(id);
	}

}
