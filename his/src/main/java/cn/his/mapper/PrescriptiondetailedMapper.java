package cn.his.mapper;

import cn.his.entity.Prescriptiondetailed;

public interface PrescriptiondetailedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Prescriptiondetailed record);

    int insertSelective(Prescriptiondetailed record);

    Prescriptiondetailed selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Prescriptiondetailed record);

    int updateByPrimaryKey(Prescriptiondetailed record);
}