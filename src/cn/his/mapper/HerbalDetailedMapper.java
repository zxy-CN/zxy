package cn.his.mapper;

import cn.his.entity.HerbalDetailed;

public interface HerbalDetailedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HerbalDetailed record);

    int insertSelective(HerbalDetailed record);

    HerbalDetailed selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HerbalDetailed record);

    int updateByPrimaryKey(HerbalDetailed record);
}