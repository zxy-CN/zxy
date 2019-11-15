package cn.his.mapper;

import cn.his.entity.ExpenseClass;

public interface ExpenseClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpenseClass record);

    int insertSelective(ExpenseClass record);

    ExpenseClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpenseClass record);

    int updateByPrimaryKey(ExpenseClass record);
}