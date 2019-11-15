package cn.his.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.his.entity.MedicalDisease;
import cn.his.mapper.MedicalDiseaseMapper;
import cn.his.services.MedicalDiseaseServices;
@Service
public class MedicalDiseaseServicesImpl implements MedicalDiseaseServices{
	@Autowired
	private MedicalDiseaseMapper mapper;
	public int add(MedicalDisease disease) {
		
		return mapper.insertSelective(disease);
	}

	public int delete(int id) {
		
		return mapper.deleteByPrimaryKey(id);
	}

	public int update(MedicalDisease disease) {
		
		return mapper.updateByPrimaryKeySelective(disease);
	}

	public MedicalDisease query(int id) {
		
		return mapper.selectByPrimaryKey(id);
	}

}
