package cn.his.mapper;

import cn.his.entity.Register;


/**
 * 挂号病历的接口
 */
public interface RegisterMapper {
    /**
     * 添加病历
     * @param record
     * @return
     */
    int insert(Register record);

    /**
     * 根据id查病历
     * @param id
     * @return
     */
    Register selectById(Integer id);

    /**
     * 根据病历号查病历
     * @param caseNumber
     * @return
     */
    Register selectByCaseNumber(String caseNumber);

    int updateVisitState(Register record);
}