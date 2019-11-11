package cn.his.mapper;

import cn.his.entity.Checkapply;

import com.sun.tools.javac.comp.Check;

public interface CheckapplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Checkapply record);

    int insertSelective(Checkapply record);

    Check selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Checkapply record);

    int updateByPrimaryKey(Checkapply record);
}