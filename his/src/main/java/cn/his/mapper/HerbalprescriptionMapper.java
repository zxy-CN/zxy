package cn.his.mapper;

import cn.his.entity.Herbalprescription;

public interface HerbalprescriptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Herbalprescription record);

    int insertSelective(Herbalprescription record);

    Herbalprescription selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Herbalprescription record);

    int updateByPrimaryKey(Herbalprescription record);
}