package cn.his.dao;

import cn.his.entity.Checkapply;

public interface CheckapplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Checkapply record);

    int insertSelective(Checkapply record);

    Checkapply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Checkapply record);

    int updateByPrimaryKey(Checkapply record);
}