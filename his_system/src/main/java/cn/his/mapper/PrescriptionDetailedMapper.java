package cn.his.mapper;

import cn.his.entity.PrescriptionDetailed;

public interface PrescriptionDetailedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrescriptionDetailed record);

    int insertSelective(PrescriptionDetailed record);

    PrescriptionDetailed selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrescriptionDetailed record);

    /**
     * 缴费
     * 根据id修改状态
     * @param id
     * @return
     */
    int updateState(Integer id);

    /**
     * 退费
     * @param id
     * @return
     */
    int returnCost(Integer id);
}