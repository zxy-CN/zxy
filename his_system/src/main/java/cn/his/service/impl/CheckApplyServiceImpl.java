package cn.his.service.impl;

import cn.his.entity.CheckApply;
import cn.his.entity.CheckNameList;
import cn.his.mapper.CheckApplyMapper;
import cn.his.service.CheckApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 申请处置业务层的实现类
 */
@Service("checkApplyService")
public class CheckApplyServiceImpl  implements CheckApplyService {
    @Autowired
    private CheckApplyMapper checkApplyMapper;
    @Override
    public int updateState(Integer id) {
        return checkApplyMapper.updateState(id);
    }

    @Override
    public int returnCost(Integer id) {
        return checkApplyMapper.returnCost(id);
    }

    @Override
    public ArrayList<CheckNameList> selectNameList() {
        return checkApplyMapper.selectNameList();
    }

    @Override
    public ArrayList<CheckNameList> selectNameListByName(String realName) {
        return checkApplyMapper.selectNameListByName(realName);
    }

    @Override
    public ArrayList<CheckApply> selectItemByRegistId(CheckApply checkApply) {
        return checkApplyMapper.selectItemByRegistId(checkApply);
    }

    @Override
    public int updateDoApply(Integer id) {
        return checkApplyMapper.updateDoApply(id);
    }

    @Override
    public int updateResult(HashMap map) {
        return checkApplyMapper.updateResult(map);
    }

}
