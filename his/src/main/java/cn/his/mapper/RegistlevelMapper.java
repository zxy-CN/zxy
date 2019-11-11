package cn.his.mapper;

import cn.his.entity.Registlevel;

public interface RegistlevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Registlevel record);

    int insertSelective(Registlevel record);

    Registlevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Registlevel record);

    int updateByPrimaryKey(Registlevel record);
}