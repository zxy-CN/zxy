package cn.his.service.impl;

import cn.his.mapper.PrescriptionDetailedMapper;
import cn.his.service.PrescriptionDetailedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("prescriptionDetailedService")
public class PrescriptionDetailedServiceImpl implements PrescriptionDetailedService {
    @Autowired
    private PrescriptionDetailedMapper prescriptionDetailedMapper;
    @Override
    public int updateState(Integer id) {
        return prescriptionDetailedMapper.updateState(id);
    }

    @Override
    public int retrunCost(Integer id) {
        return prescriptionDetailedMapper.returnCost(id);
    }


}
