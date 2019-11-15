package cn.his.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.his.entity.DrugsTemplate;
import cn.his.mapper.DrugsTemplateMapper;
import cn.his.services.DrugsTemplateServices;
@Service
public class DrugsTemplateServicesImpl implements DrugsTemplateServices{
	@Autowired
	private DrugsTemplateMapper mapper;
	public int add(DrugsTemplate drugsTemplate) {

		return mapper.insertSelective(drugsTemplate);
	}

	public int update(DrugsTemplate drugsTemplate) {

		return mapper.updateByPrimaryKeySelective(drugsTemplate);
	}

	public int delete(int id) {

		return mapper.deleteByPrimaryKey(id);
	}

	public DrugsTemplate query(int id) {

		return mapper.selectByPrimaryKey(id);
	}

	

	public ArrayList<DrugsTemplate> getDrugsTemplates(
			DrugsTemplate drugsTemplate) {
	
		return mapper.selectAll(drugsTemplate);
	}

	
}
