package cn.his.mapper;

import cn.his.entity.VChargeHerbal;

import java.util.ArrayList;

/**
 * 草药消费视图的接口
 */
public interface VChargeHerbalMapper {
    /**
     * 根据病历号查
     * @param caseNumber
     * @return
     */
    ArrayList<VChargeHerbal> selectByCaseNumber(String caseNumber);

    /**
     * 根据草药id号查
     * @param id
     * @return
     */
    VChargeHerbal selectByID(Integer id);
}