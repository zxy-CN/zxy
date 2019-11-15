package cn.his.services;

import java.util.ArrayList;

import cn.his.entity.HerbalTempDetailed;
/**
 * 
 * @author 吴权鸿
 * time 2019-11-13
 */
public interface HerbalTempDetailedServices {

	/**
	 * 添加草药处方模板明细表
	 */
	int add(HerbalTempDetailed herbalTempDetailed);
	/**
	 * 修改草药处方模板明细表
	 */
	int update(HerbalTempDetailed herbalTempDetailed);
	/**
	 * 删除草药处方模板明细表
	 */
	int delete(Integer id);
	/**
	 * 查询草药处方模板明细表
	 */
	ArrayList<HerbalTempDetailed> getHerbalTempDetailedsById(Integer id);
}
