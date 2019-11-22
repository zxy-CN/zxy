package cn.his.service;

import cn.his.entity.PatientCosts;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 消费明细的业务层接口
 */
public interface PatientCostsService {

    /**
     * 添加药品消费明细
     * @param patientCosts
     * @return
     */
    int insertCApply(PatientCosts patientCosts);

    /**
     * 添加非药品消费明细
     * @param patientCosts
     * @return
     */
    int insertMid(PatientCosts patientCosts);

    /**
     * 根据挂号id查收费的项目
     * @param map
     * @return
     */
    ArrayList<PatientCosts> selectByRegistID(HashMap map);
}
