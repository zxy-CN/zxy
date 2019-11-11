package cn.his.dao;

import cn.his.entity.Drugs;

public interface DrugsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Drugs record);

    int insertSelective(Drugs record);

    Drugs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Drugs record);

    int updateByPrimaryKey(Drugs record);
}