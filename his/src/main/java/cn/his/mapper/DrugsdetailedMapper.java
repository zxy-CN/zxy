package cn.his.mapper;

import cn.his.entity.Drugsdetailed;

public interface DrugsdetailedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Drugsdetailed record);

    int insertSelective(Drugsdetailed record);

    Drugsdetailed selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Drugsdetailed record);

    int updateByPrimaryKey(Drugsdetailed record);
}