package cn.his.service.impl;

import cn.his.mapper.CheckApplyMapper;
import cn.his.service.CheckApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
