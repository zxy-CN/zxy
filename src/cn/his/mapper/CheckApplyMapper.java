package cn.his.mapper;

import cn.his.entity.CheckApply;

public interface CheckApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckApply record);

    int insertSelective(CheckApply record);

    CheckApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckApply record);

    int updateByPrimaryKey(CheckApply record);
}