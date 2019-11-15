package cn.his.service;

import cn.his.entity.VChargePrescription;

import java.util.ArrayList;

/**
 * 成药消费视图的业务层接口
 */
public interface VChargePrescriptionService {
    /**
     * 根据病历号查成药消费
     * @param caseNumber
     * @return
     */
    ArrayList<VChargePrescription> getPrescription(String caseNumber);
}
