package cn.his.dao;

import cn.his.entity.Disecategory;

public interface DisecategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Disecategory record);

    int insertSelective(Disecategory record);

    Disecategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Disecategory record);

    int updateByPrimaryKey(Disecategory record);
}