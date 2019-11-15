package cn.his.services;

import cn.his.entity.ExpenseClass;
/**
 * 
 * @author 吴权鸿
 * time 2019-11-13
 */
public interface ExpenseClassServices {
	/**
	 * 添加费用科目表
	 */
	int add(ExpenseClass expenseClass);
	/**
	 * 修改费用科目表
	 */
	int update(ExpenseClass expenseClass);
	/**
	 * 删除费用科目表
	 */
	int delete(int id);
	/**
	 * 查询费用科目表
	 */
	ExpenseClass query(int id);
}
