package cn.his.mapper;

import cn.his.entity.Registwork;

public interface RegistworkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Registwork record);

    int insertSelective(Registwork record);

    Registwork selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Registwork record);

    int updateByPrimaryKey(Registwork record);
}