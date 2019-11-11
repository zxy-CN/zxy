package cn.his.dao;

import cn.his.entity.Constanttype;

public interface ConstanttypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Constanttype record);

    int insertSelective(Constanttype record);

    Constanttype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Constanttype record);

    int updateByPrimaryKey(Constanttype record);
}