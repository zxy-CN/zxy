package cn.his.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.his.entity.CheckTemplate;
import cn.his.mapper.CheckTemplateMapper;
import cn.his.services.CheckTemplateServices;
@Service
public class CheckTemplateServicesImpl implements CheckTemplateServices{
	@Autowired
	private CheckTemplateMapper mapper;
	public int add(CheckTemplate checkTemplate) {
		
		return mapper.insertSelective(checkTemplate);
	}

	public int update(CheckTemplate checkTemplate) {
		
		return mapper.updateByPrimaryKeySelective(checkTemplate);
	}

	public int delete(Integer id) {
		
		return mapper.deleteByPrimaryKey(id);
	}

	public CheckTemplate query(Integer id) {
		
		return mapper.selectByPrimaryKey(id);
	}

	public ArrayList<CheckTemplate> getCheckTemplates(
			CheckTemplate checkTemplate) {
	
		return mapper.selectAllByLimit(checkTemplate);
	}

}
