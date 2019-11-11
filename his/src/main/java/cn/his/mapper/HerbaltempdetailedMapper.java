package cn.his.mapper;

import cn.his.entity.Herbaltempdetailed;

public interface HerbaltempdetailedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Herbaltempdetailed record);

    int insertSelective(Herbaltempdetailed record);

    Herbaltempdetailed selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Herbaltempdetailed record);

    int updateByPrimaryKey(Herbaltempdetailed record);
}