package cn.his.mapper;

import cn.his.entity.SettleCategory;

public interface SettleCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SettleCategory record);

    int insertSelective(SettleCategory record);

    SettleCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SettleCategory record);

    int updateByPrimaryKey(SettleCategory record);
}