package cn.his.mapper;

import cn.his.entity.VChargeCapply;

import java.util.ArrayList;

/**
 * 处置消费视图的接口
 */
public interface VChargeCapplyMapper {
    /**
     * 根据病历号查
     * @param caseNumber
     * @return
     */
    ArrayList<VChargeCapply> selectByCaseNumber(String caseNumber);
}