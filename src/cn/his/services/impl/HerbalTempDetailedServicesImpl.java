package cn.his.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.his.entity.HerbalTempDetailed;
import cn.his.mapper.HerbalTempDetailedMapper;
import cn.his.services.HerbalTempDetailedServices;
@Service
public class HerbalTempDetailedServicesImpl implements HerbalTempDetailedServices {
	@Autowired
	private HerbalTempDetailedMapper mapper;
	public int add(HerbalTempDetailed herbalTempDetailed) {

		return mapper.insertSelective(herbalTempDetailed);
	}

	public int update(HerbalTempDetailed herbalTempDetailed) {

		return mapper.updateByPrimaryKeySelective(herbalTempDetailed);
	}

	public int delete(Integer id) {

		return mapper.deleteByPrimaryKey(id);
	}

	public ArrayList<HerbalTempDetailed> getHerbalTempDetailedsById(Integer id) {
		
		return mapper.selectByPrimaryKey(id);
	}

}
