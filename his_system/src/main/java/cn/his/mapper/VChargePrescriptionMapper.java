package cn.his.mapper;

import cn.his.entity.VChargePrescription;

import java.util.ArrayList;

/**
 * 成药消费视图的接口
 */
public interface VChargePrescriptionMapper {
    /**
     * 根据病历号查成药消费
     * @param caseNumber
     * @return
     */
    ArrayList<VChargePrescription> selectByCaseNumber(String caseNumber);

    /**
     * 根据成药id号查
     * @param id
     * @return
     */
    VChargePrescription selectByID(Integer id);
}