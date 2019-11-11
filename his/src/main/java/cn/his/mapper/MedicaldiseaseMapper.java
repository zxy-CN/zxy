package cn.his.mapper;

import cn.his.entity.Medicaldisease;

public interface MedicaldiseaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Medicaldisease record);

    int insertSelective(Medicaldisease record);

    Medicaldisease selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Medicaldisease record);

    int updateByPrimaryKey(Medicaldisease record);
}