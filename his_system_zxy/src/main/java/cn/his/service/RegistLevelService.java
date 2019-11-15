package cn.his.service;

import cn.his.entity.RegistLevel;

import java.util.ArrayList;

/**
 * 挂号级别业务层接口
 */
public interface RegistLevelService {

    /**
     * 挂号时查询的挂号级别数据
     * @return
     */
    ArrayList<RegistLevel> selectRegLevel();
}
