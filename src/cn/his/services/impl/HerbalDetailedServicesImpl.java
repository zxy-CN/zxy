package cn.his.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.his.entity.HerbalDetailed;
import cn.his.mapper.HerbalDetailedMapper;
import cn.his.services.HerbalDetailedServices;
@Service
public class HerbalDetailedServicesImpl implements HerbalDetailedServices {
	@Autowired
	private HerbalDetailedMapper mapper;
	public int add(HerbalDetailed herbalDetailed) {

		return mapper.insertSelective(herbalDetailed);
	}

	public int update(HerbalDetailed herbalDetailed) {

		return mapper.updateByPrimaryKeySelective(herbalDetailed);
	}

	public int delete(Integer id) {

		return mapper.deleteByPrimaryKey(id);
	}

	public ArrayList<HerbalDetailed> getHerbalDetailedsById(Integer id) {

		return mapper.selectByPrimaryKey(id);
	}

}
