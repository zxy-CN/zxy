package cn.his.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.his.entity.HerbalPrescription;
import cn.his.mapper.HerbalPrescriptionMapper;
import cn.his.services.HerbalPrescriptionServices;
@Service
public class HerbalPrescriptionServicesImpl implements HerbalPrescriptionServices{
	@Autowired
	private HerbalPrescriptionMapper mapper;
	public int add(HerbalPrescription herbalPrescription) {

		return mapper.insertSelective(herbalPrescription);
	}

	public int update(HerbalPrescription herbalPrescription) {

		return mapper.updateByPrimaryKeySelective(herbalPrescription);
	}

	public int delete(int id) {

		return mapper.deleteByPrimaryKey(null);
	}

	public HerbalPrescription query(int id) {

		return mapper.selectByPrimaryKey(id);
	}
	
	
	
}
