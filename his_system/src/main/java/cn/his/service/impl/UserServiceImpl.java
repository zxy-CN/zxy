package cn.his.service.impl;

import cn.his.entity.User;
import cn.his.mapper.UserMapper;
import cn.his.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ArrayList<User> selectRegDoc() {
        return userMapper.selectRegDoc();
    }
}
