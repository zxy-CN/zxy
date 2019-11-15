package cn.his.service;

import cn.his.entity.Register;

/**
 * 病历接口
 */
public interface RegisterService {
    /**
     * 添加病历
     * @param register
     * @return
     */
    int addReg(Register register);

    /**
     * 根据id查病历
     * @param id
     * @return
     */
    Register getRegById(Integer id);

    /**
     * 根据病历号查病历
     * @param caseNumber
     * @return
     */
    Register getRegByCaseNumber(String caseNumber);

    /**
     * 退号
     * @param register
     * @return
     */
    int returnReg(Register register);
}
