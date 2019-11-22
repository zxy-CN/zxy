package cn.his.mapper;

import cn.his.entity.PatientCosts;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *患者费用明细的接口
 */
public interface PatientCostsMapper {
    /**
     * 根据挂号id查收费的项目
     * @param map
     * @return
     */
    ArrayList<PatientCosts> selectByRegistID(HashMap map);

    /**
     * 添加非药品消费明细
     * @param patientCosts
     * @return
     */
    int insertCApply(PatientCosts patientCosts);

    /**
     * 添加药品消费明细
     * @return
     */
    int insertMid(PatientCosts patientCosts);
}