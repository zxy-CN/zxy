package cn.his.mapper;

import cn.his.entity.RegistWork;
import cn.his.entity.WorkSelect;

import java.util.ArrayList;
import java.util.HashMap;

public interface RegistWorkMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加日结记录
     * @param registWork
     * @return
     */
    int insert(RegistWork registWork);

    int insertSelective(RegistWork record);

    RegistWork selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RegistWork record);

    int updateByPrimaryKey(RegistWork record);

    /**
     * 查上次日结结束时间
     * @return
     */
    String selectEndTime();

    /**
     * 给定时间区间，查日结记录
     * @param map
     * @return
     */
    ArrayList<WorkSelect> selectAll(HashMap map);
}