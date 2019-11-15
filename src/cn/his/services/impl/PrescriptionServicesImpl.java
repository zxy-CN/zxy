package cn.his.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.his.entity.Prescription;
import cn.his.mapper.PrescriptionMapper;
import cn.his.services.PrescriptionServices;
@Service
public class PrescriptionServicesImpl implements PrescriptionServices{
	@Autowired
	private PrescriptionMapper mapper;
	public int add(Prescription prescription) {
		
		return mapper.insertSelective(prescription);
	}

	public int update(Prescription prescription) {
		
		return mapper.updateByPrimaryKeySelective(prescription);
	}

	public int delete(int id) {
		
		return mapper.deleteByPrimaryKey(id);
	}

	public Prescription query(int id) {
		
		return mapper.selectByPrimaryKey(id);
	}

}
