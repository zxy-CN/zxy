package cn.his.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.his.entity.DrugsDetailed;
import cn.his.mapper.DrugsDetailedMapper;
import cn.his.services.DrugsDetailedServices;
@Service
public class DrugsDetailedServicesImpl implements DrugsDetailedServices{
	@Autowired
	DrugsDetailedMapper mapper;
	public int add(DrugsDetailed drugsDetailed) {

		return mapper.insertSelective(drugsDetailed);
	}

	public int update(DrugsDetailed drugsDetailed) {

		return mapper.updateByPrimaryKeySelective(drugsDetailed);
	}

	public int delete(Integer id) {

		return mapper.deleteByPrimaryKey(id);
	}

	public DrugsDetailed query(int id) {

		return mapper.selectByPrimaryKey(id);
	}

	public ArrayList<DrugsDetailed> getDrugsDetaileds(Integer id) {
		
		return mapper.selectAllByTempId(id);
	}

}
