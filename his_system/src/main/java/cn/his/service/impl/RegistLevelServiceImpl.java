package cn.his.service.impl;

import cn.his.entity.RegistLevel;
import cn.his.mapper.RegistLevelMapper;
import cn.his.service.RegistLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 挂号级别业务层的实现类
 */
@Service("registLevelService")
public class RegistLevelServiceImpl implements RegistLevelService {
    @Autowired
    private RegistLevelMapper registLevelMapper;
    @Override
    public ArrayList<RegistLevel> selectRegLevel() {
        return registLevelMapper.selectRegLevel();
    }
}
