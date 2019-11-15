package cn.his.service;

import cn.his.entity.SettleCategory;

import java.util.ArrayList;

/**
 * 结算类别的业务层接口
 */
public interface SettleCategoryService {
    /**
     * 用于挂号时拉取结算类型
     */
    ArrayList<SettleCategory> selectRegSType();
}
