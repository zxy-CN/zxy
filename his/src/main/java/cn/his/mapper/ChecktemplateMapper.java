package cn.his.mapper;

import cn.his.entity.Checktemplate;

public interface ChecktemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Checktemplate record);

    int insertSelective(Checktemplate record);

    Checktemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Checktemplate record);

    int updateByPrimaryKey(Checktemplate record);
}