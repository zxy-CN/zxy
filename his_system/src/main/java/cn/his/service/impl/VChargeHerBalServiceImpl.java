package cn.his.service.impl;

import cn.his.entity.VChargeHerbal;
import cn.his.mapper.VChargeHerbalMapper;
import cn.his.service.VChargeHerBalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 草药消费视图业务层接口的实现类
 */
@Service("herBalService")
public class VChargeHerBalServiceImpl implements VChargeHerBalService {
    @Autowired
    private VChargeHerbalMapper vChargeHerbalMapper;


    @Override
    public ArrayList<VChargeHerbal> getHerBal(String caseNumber) {
        return vChargeHerbalMapper.selectByCaseNumber(caseNumber);
    }

    @Override
    public VChargeHerbal selectByID(Integer id) {
        return vChargeHerbalMapper.selectByID(id);
    }
}
