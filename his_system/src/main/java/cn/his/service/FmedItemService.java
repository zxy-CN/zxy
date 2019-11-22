package cn.his.service;

import cn.his.entity.FmedItem;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;

/**
 * 处置的业务层接口
 */
public interface FmedItemService {

    /**
     * 查询
     * @param itemName
     * @return
     */
    ArrayList<FmedItem> selectByName(String itemName);

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param itemName
     * @return
     */
    PageInfo<FmedItem> findAll(int pageNum, int pageSize,String itemName);

    /**
     * 添加
     * @param fmedItem
     * @return
     */
    int insert(FmedItem fmedItem);

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
