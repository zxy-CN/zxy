package cn.his.service.impl;

import cn.his.entity.ConstatntItem;
import cn.his.mapper.ConstatntItemMapper;
import cn.his.service.ConstatntltemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service("constatntltemService")
public class ConstatntltemServiceImpl implements ConstatntltemService {

    @Autowired
    private ConstatntItemMapper constatntItemMapper;
    @Override
    public ArrayList<ConstatntItem> selectSex() {
        return constatntItemMapper.selectSex();
    }

    @Override
    public ArrayList<ConstatntItem> selectMTC() {
        return constatntItemMapper.selectMTC();
    }
}
