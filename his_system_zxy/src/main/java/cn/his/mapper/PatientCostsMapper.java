package cn.his.mapper;

import cn.his.entity.PatientCosts;

import java.util.ArrayList;
/**
 *患者费用明细的接口
 */
public interface PatientCostsMapper {
    /**
     * 根据挂号id查收费的项目
     * @param registId
     * @return
     */
    ArrayList<PatientCosts> selectByRegistID(Integer registId);
}