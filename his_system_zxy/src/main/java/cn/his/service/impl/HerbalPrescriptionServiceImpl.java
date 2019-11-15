package cn.his.service.impl;

import cn.his.mapper.HerbalPrescriptionMapper;
import cn.his.service.HerbalPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 草药业务层接口的实现类
 */
@Service("herbalPrescriptionService")
public class HerbalPrescriptionServiceImpl implements HerbalPrescriptionService {
    @Autowired
    private HerbalPrescriptionMapper herbalPrescriptionMapper;


    @Override
    public int updateState(Integer id) {
        return herbalPrescriptionMapper.updateState(id);
    }
}
