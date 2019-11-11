package cn.his.dao;

import cn.his.entity.Checkrelation;

public interface CheckrelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Checkrelation record);

    int insertSelective(Checkrelation record);

    Checkrelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Checkrelation record);

    int updateByPrimaryKey(Checkrelation record);
}