package cn.his.mapper;

import cn.his.entity.HerbalPrescription;

public interface HerbalPrescriptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HerbalPrescription record);

    int insertSelective(HerbalPrescription record);

    HerbalPrescription selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HerbalPrescription record);

    int updateState(Integer id);
}