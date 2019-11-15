package cn.his.service;

import cn.his.entity.User;

import java.util.ArrayList;

/**
 * 用户业务层接口
 */
public interface UserService {

    /**
     * 挂号时拉取的医生数据
     * @return
     */
    ArrayList<User> selectRegDoc();
}
