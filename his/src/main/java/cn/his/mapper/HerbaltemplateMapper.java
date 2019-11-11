package cn.his.mapper;

import cn.his.entity.Herbaltemplate;

public interface HerbaltemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Herbaltemplate record);

    int insertSelective(Herbaltemplate record);

    Herbaltemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Herbaltemplate record);

    int updateByPrimaryKey(Herbaltemplate record);
}