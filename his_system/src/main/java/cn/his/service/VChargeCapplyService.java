package cn.his.service;

import cn.his.entity.VChargeCapply;

import java.util.ArrayList;

/**
 * 处置消费视图的业务层接口
 */
public interface VChargeCapplyService {
    /**
     * 根据病历号查处置消费信息
     * @param caseNumber
     * @return
     */
    ArrayList<VChargeCapply> getCapply(String caseNumber);

    /**
     * 根据项目id查
     * @param id
     * @return
     */
    VChargeCapply selectByID(Integer id);
}
