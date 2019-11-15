package cn.his.mapper;

import cn.his.entity.User;

import java.util.ArrayList;

public interface UserMapper {
    /**
     * 挂号时拉取的医生数据
     * @return
     */
    ArrayList<User> selectRegDoc();
}