package cn.his.service.impl;

import cn.his.entity.RegistWork;
import cn.his.entity.WorkSelect;
import cn.his.mapper.RegistWorkMapper;
import cn.his.service.RegistWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service("registWorkService")
public class RegistWorkServiceImpl implements RegistWorkService {
    @Autowired
    private RegistWorkMapper registWorkMapper;
    @Override
    public String selectEndTime() {
        return registWorkMapper.selectEndTime();
    }

    @Override
    public int insert(RegistWork registWork) {
        return registWorkMapper.insert(registWork);
    }

    @Override
    public ArrayList<WorkSelect> selectAll(HashMap map) {
        return registWorkMapper.selectAll(map);
    }
}
