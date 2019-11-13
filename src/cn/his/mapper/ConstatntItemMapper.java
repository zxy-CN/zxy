package cn.his.mapper;

import cn.his.entity.ConstatntItem;

public interface ConstatntItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConstatntItem record);

    int insertSelective(ConstatntItem record);

    ConstatntItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConstatntItem record);

    int updateByPrimaryKey(ConstatntItem record);
}