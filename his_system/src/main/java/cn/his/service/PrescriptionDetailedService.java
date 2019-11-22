package cn.his.service;

/**
 *成药业务层的接口
 */
public interface PrescriptionDetailedService {
    /**
     * 根据id 修改状态
     * @param id
     * @return
     */
    int updateState(Integer id);

    /**
     * 退费
     * @param id
     * @return
     */
    int retrunCost(Integer id);
}
