package cn.his.service;

/**
 * 处置申请表业务层接口
 */
public interface CheckApplyService {
    /**
     * 根据id改变状态
     * （结账）
     * @param id
     * @return
     */
    int updateState(Integer id);
}
