package cn.his.mapper;

import cn.his.entity.CheckRelation;

public interface CheckRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckRelation record);

    int insertSelective(CheckRelation record);

    CheckRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckRelation record);

    int updateByPrimaryKey(CheckRelation record);
}