package cn.his.service;

import cn.his.entity.VChargeHerbal;

import java.util.ArrayList;

/**
 *草药消费视图的业务层接口
 */
public interface VChargeHerBalService {
    /**
     * 根据病历号查草药消费信息
     * @param caseNumber
     * @return
     */
    ArrayList<VChargeHerbal> getHerBal(String caseNumber);

    /**
     * 根据草药id号查
     * @param id
     * @return
     */
    VChargeHerbal selectByID(Integer id);
}
