package cn.his.service;

import cn.his.entity.RegistWork;
import cn.his.entity.WorkSelect;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 操作管理员日结表的业务层接口
 */
public interface RegistWorkService {

    /**
     * 查上次日结结束时间
     * @return
     */
    String selectEndTime();

    /**
     * 添加日结记录
     * @param registWork
     * @return
     */
    int insert(RegistWork registWork);

    /**
     * 给定时间区间，查日结记录
     * @param map
     * @return
     */
    ArrayList<WorkSelect> selectAll(HashMap map);
}
