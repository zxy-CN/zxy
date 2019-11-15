package cn.his.mapper;

import cn.his.entity.RegistLevel;

import java.util.ArrayList;

public interface RegistLevelMapper {
    /**
     * 挂号时查询的挂号级别数据
     * @return
     */
    ArrayList<RegistLevel> selectRegLevel();
}