package cn.his.dao;

import cn.his.entity.Drugstemplate;

public interface DrugstemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Drugstemplate record);

    int insertSelective(Drugstemplate record);

    Drugstemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Drugstemplate record);

    int updateByPrimaryKey(Drugstemplate record);
}