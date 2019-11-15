package cn.his.mapper;

import cn.his.entity.FmedItem;

public interface FmedItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FmedItem record);

    int insertSelective(FmedItem record);

    FmedItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FmedItem record);

    int updateByPrimaryKey(FmedItem record);
}