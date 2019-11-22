package cn.his.service.impl;

import cn.his.entity.PatientCosts;
import cn.his.mapper.PatientCostsMapper;
import cn.his.service.PatientCostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service("patientCostsService")
public class PatientCostsServiceImpl implements PatientCostsService {
    @Autowired
    private PatientCostsMapper patientCostsMapper;

    @Override
    public int insertCApply(PatientCosts patientCosts) {
        return patientCostsMapper.insertCApply(patientCosts);
    }

    @Override
    public int insertMid(PatientCosts patientCosts) {
        return patientCostsMapper.insertCApply(patientCosts);
    }

    @Override
    public ArrayList<PatientCosts> selectByRegistID(HashMap map) {
        return patientCostsMapper.selectByRegistID(map);
    }
}
