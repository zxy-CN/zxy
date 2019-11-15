package cn.his.mapper;

import cn.his.entity.CheckApply;

import java.util.ArrayList;

public interface CheckApplyMapper {

    /**
     * 根据挂号id查项目
     *
     */
    ArrayList<CheckApply> selectByRegistId(Integer registId);

    /**
     * 根据id修改状态
     */
    int updateState(Integer id);
}