package cn.his.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.his.entity.PrescriptionDetailed;
import cn.his.mapper.PrescriptionDetailedMapper;
import cn.his.services.PrescriptionDetailedServices;
/**
 * 
 * @author 吴权鸿
 *	time 2019-11-13
 */
@Service
public class PrescriptionDetailedServicesImpl implements PrescriptionDetailedServices{
	@Autowired PrescriptionDetailedMapper mapper;
	public int add(PrescriptionDetailed prescriptionDetailed) {

		return mapper.insertSelective(prescriptionDetailed);
	}

	public int update(PrescriptionDetailed prescriptionDetailed) {

		return mapper.updateByPrimaryKeySelective(prescriptionDetailed);
	}

	public int delete(int id) {

		return mapper.deleteByPrimaryKey(id);
	}

	public PrescriptionDetailed query(int id) {

		return mapper.selectByPrimaryKey(id);
	}

}
