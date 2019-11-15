package cn.his.mapper;

import cn.his.entity.ConstatntItem;

import java.util.ArrayList;

public interface ConstatntItemMapper {
    /**
     * 查性别
     * @return
     */
    ArrayList<ConstatntItem> selectSex();

    /**
     * 查收费方式
     * @return
     */
    ArrayList<ConstatntItem> selectMTC();
}