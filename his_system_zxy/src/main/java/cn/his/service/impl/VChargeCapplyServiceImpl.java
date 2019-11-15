package cn.his.service.impl;

import cn.his.entity.VChargeCapply;
import cn.his.mapper.VChargeCapplyMapper;
import cn.his.service.VChargeCapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 处置视图的实现类
 */
@Service("vCapplyService")
public class VChargeCapplyServiceImpl  implements VChargeCapplyService {

    @Autowired
    private VChargeCapplyMapper vChargeCapplyMapper;

    @Override
    public ArrayList<VChargeCapply> getCapply(String caseNumber) {
        return vChargeCapplyMapper.selectByCaseNumber(caseNumber);
    }
}
