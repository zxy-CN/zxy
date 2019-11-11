package cn.his.dao;

import cn.his.entity.Expenseclass;

public interface ExpenseclassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Expenseclass record);

    int insertSelective(Expenseclass record);

    Expenseclass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Expenseclass record);

    int updateByPrimaryKey(Expenseclass record);
}