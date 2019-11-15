package cn.his.service.impl;

import cn.his.entity.SettleCategory;
import cn.his.mapper.SettleCategoryMapper;
import cn.his.service.SettleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("settleCategoryServiceI")
public class SettleCategoryServiceImpl implements SettleCategoryService{
    @Autowired
    private SettleCategoryMapper settleCategoryMapper;

    @Override
    public ArrayList<SettleCategory> selectRegSType() {
        return settleCategoryMapper.selectRegSType();
    }
}
