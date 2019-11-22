package cn.his.service.impl;

import cn.his.entity.VChargePrescription;
import cn.his.mapper.VChargePrescriptionMapper;
import cn.his.service.VChargePrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 成药消费视图业务层接口的实现类
 */
@Service("PrescriptionService")
public class VChargePrescriptionServiceImpl implements VChargePrescriptionService {
    @Autowired
    private VChargePrescriptionMapper vChargePrescriptionMapper;


    @Override
    public ArrayList<VChargePrescription> getPrescription(String caseNumber) {
        return vChargePrescriptionMapper.selectByCaseNumber(caseNumber);
    }

    @Override
    public VChargePrescription selectByID(Integer id) {
        return vChargePrescriptionMapper.selectByID(id);
    }
}
