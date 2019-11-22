package cn.his.mapper;

import cn.his.entity.CheckTemplate;

public interface CheckTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckTemplate record);

    int insertSelective(CheckTemplate record);

    CheckTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckTemplate record);

    int updateByPrimaryKey(CheckTemplate record);
}