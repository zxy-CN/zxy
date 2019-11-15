package cn.his.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.his.entity.HerbalTemplate;
import cn.his.mapper.HerbalTemplateMapper;
import cn.his.services.HerbalTemplateServices;
@Service
public class HerbalTemplateServicesImpl implements HerbalTemplateServices{
	@Autowired
	private HerbalTemplateMapper mapper;
	public int add(HerbalTemplate herbalTemplate) {

		return mapper.insertSelective(herbalTemplate);
	}

	public int update(HerbalTemplate herbalTemplate) {

		return mapper.updateByPrimaryKeySelective(herbalTemplate);
	}

	public int delete(Integer id) {

		return mapper.deleteByPrimaryKey(id);
	}

	public HerbalTemplate query(Integer id) {

		return mapper.selectByPrimaryKey(id);
	}

	public ArrayList<HerbalTemplate> getHerbalTemplates(HerbalTemplate herbalTemplate) {
		
		return mapper.selectAll(herbalTemplate);
	}

	public ArrayList<HerbalTemplate> getHerbalTemplates() {
		
		return mapper.getAll();
	}

}
