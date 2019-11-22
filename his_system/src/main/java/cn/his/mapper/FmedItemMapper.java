package cn.his.mapper;

import cn.his.entity.FmedItem;

import java.util.ArrayList;

public interface FmedItemMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加
     * @param fmedItem
     * @return
     */
    int insert(FmedItem fmedItem);

    int insertSelective(FmedItem record);

    /**
     * 查询
     * @param itemName
     * @return
     */
    ArrayList<FmedItem> selectByName(String itemName);

    /**
     * 修改
     * @param fmedItem
     * @return
     */
    int updateById(FmedItem fmedItem);

    /**
     * 删除
     * @param fmedItem
     * @return
     */
    int deleteById(FmedItem fmedItem);
}