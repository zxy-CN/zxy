package cn.his.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.his.entity.CheckApply;
import cn.his.mapper.CheckApplyMapper;
import cn.his.services.CheckApplyServices;
@Service
public class CheckApplyServicesImpl implements CheckApplyServices{
	@Autowired
	private CheckApplyMapper mapper;
	public int add(CheckApply checkApply) {
		
		return mapper.insertSelective(checkApply);
	}

	public int update(CheckApply checkApply) {
		
		return mapper.updateByPrimaryKeySelective(checkApply);
	}

	public int delete(int id) {
		
		return mapper.deleteByPrimaryKey(id);
	}

	public CheckApply query(int id) {
		
		return mapper.selectByPrimaryKey(id);
	}

	
}
