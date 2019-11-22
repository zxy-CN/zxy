package cn.his.service;

import cn.his.entity.CheckApply;
import cn.his.entity.CheckNameList;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 处置申请表业务层接口
 */
public interface CheckApplyService {
    /**
     * 根据id改变状态
     * （结账）
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

    /**
     * 医技模块时拉取患者列表使用
     * @return
     */
    ArrayList<CheckNameList> selectNameList();

    /**
     * 根据患者姓名模糊查询
     * @return
     */
    ArrayList<CheckNameList> selectNameListByName(String realName);

    /**
     * 患者具体处置项目查询
     * @return
     */
    ArrayList<CheckApply> selectItemByRegistId(CheckApply checkApply);

    /**
     * 更改状态已执行
     * @param id
     * @return
     */
    int updateDoApply(Integer id);

    /**
     * 填写检查结果
     * @param map
     * @return
     */
    int updateResult(HashMap map);
}
