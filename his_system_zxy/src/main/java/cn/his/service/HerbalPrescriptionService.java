package cn.his.service;

/**
 * 草药业务层接口
 */
public interface HerbalPrescriptionService {
    /**
     * 根据id更改状态
     * @param id
     * @return
     */
    int updateState(Integer id);
}
