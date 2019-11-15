package cn.his.mapper;

import cn.his.entity.RegistWork;

public interface RegistWorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RegistWork record);

    int insertSelective(RegistWork record);

    RegistWork selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RegistWork record);

    int updateByPrimaryKey(RegistWork record);
}