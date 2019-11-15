package cn.his.service;

import cn.his.entity.ConstatntItem;

import java.util.ArrayList;

/**
 * 常数项表业务层的接口
 */
public interface ConstatntltemService {
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
