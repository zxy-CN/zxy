package cn.his.mapper;

import cn.his.entity.SettleCategory;

import java.util.ArrayList;

public interface SettleCategoryMapper {
    /**
     * 用于挂号时拉取结算类型
     */
    ArrayList<SettleCategory> selectRegSType();
}