package cn.his.mapper;

import cn.his.entity.ConstatntType;

public interface ConstatntTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConstatntType record);

    int insertSelective(ConstatntType record);

    ConstatntType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConstatntType record);

    int updateByPrimaryKey(ConstatntType record);
}