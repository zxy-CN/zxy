package cn.his.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.his.entity.CheckRelation;
import cn.his.mapper.CheckRelationMapper;
import cn.his.services.CheckRelationServices;
@Service
public class CheckRelationServicesImpl implements CheckRelationServices{
	@Autowired
	private CheckRelationMapper mapper;
	public int add(CheckRelation checkRelation) {
		
		return mapper.insertSelective(checkRelation);
	}

	public int update(CheckRelation checkRelation) {
		
		return mapper.updateByPrimaryKeySelective(checkRelation);
	}

	public int delete(Integer id) {
		
		return mapper.deleteByPrimaryKey(id);
	}

	public ArrayList<CheckRelation> getCheckRelationsById(Integer id) {
		
		return mapper.selectByPrimaryKey(id);
	}

	

}
