package cn.his.service.impl;

import cn.his.entity.Register;
import cn.his.mapper.RegisterMapper;
import cn.his.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 病历业务接口的实现类
 */
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterMapper registerMapper;


    @Override
    public Integer getCount() {
        return registerMapper.getCount();
    }

    @Override
    public int addReg(Register register) {
        return registerMapper.insert(register);
    }

    @Override
    public Register getRegById(Integer id) {
        return registerMapper.selectById(id);
    }

    @Override
    public Register getRegByCaseNumber(String caseNumber) {
        return registerMapper.selectByCaseNumber(caseNumber);
    }

    @Override
    public int returnReg(Register register) {
        return registerMapper.updateVisitState(register);
    }

}
