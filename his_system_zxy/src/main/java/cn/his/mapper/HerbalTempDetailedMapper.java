package cn.his.mapper;

import cn.his.entity.HerbalTempDetailed;

public interface HerbalTempDetailedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HerbalTempDetailed record);

    int insertSelective(HerbalTempDetailed record);

    HerbalTempDetailed selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HerbalTempDetailed record);

    int updateByPrimaryKey(HerbalTempDetailed record);
}