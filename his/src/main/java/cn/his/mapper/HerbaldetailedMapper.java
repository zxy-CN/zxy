package cn.his.mapper;

import cn.his.entity.Herbaldetailed;

public interface HerbaldetailedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Herbaldetailed record);

    int insertSelective(Herbaldetailed record);

    Herbaldetailed selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Herbaldetailed record);

    int updateByPrimaryKey(Herbaldetailed record);
}