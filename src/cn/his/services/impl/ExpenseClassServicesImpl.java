package cn.his.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.his.entity.ExpenseClass;
import cn.his.mapper.ExpenseClassMapper;
import cn.his.services.ExpenseClassServices;
@Service
public class ExpenseClassServicesImpl implements ExpenseClassServices{
	@Autowired
	private ExpenseClassMapper mapper;
	public int add(ExpenseClass expenseClass) {

		return mapper.insertSelective(expenseClass);
	}

	public int update(ExpenseClass expenseClass) {

		return mapper.updateByPrimaryKeySelective(expenseClass);
	}

	public int delete(int id) {

		return mapper.deleteByPrimaryKey(id);
	}

	public ExpenseClass query(int id) {

		return mapper.selectByPrimaryKey(id);
	}

}
