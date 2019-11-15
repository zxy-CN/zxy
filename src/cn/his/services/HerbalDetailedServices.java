package cn.his.services;



import java.util.ArrayList;

import cn.his.entity.HerbalDetailed;
/**
 * 
 * @author 吴权鸿
 * time 2019-11-13
 */
public interface HerbalDetailedServices {

	/**
	 * 添加草药处方明细表
	 */
	int add(HerbalDetailed herbalDetailed);
	/**
	 * 修改草药处方明细表
	 */
	int update(HerbalDetailed herbalDetailed);
	/**
	 * 删除草药处方明细表
	 */
	int delete(Integer id);
	/**
	 * 查询草药处方明细表 
	 */
	ArrayList<HerbalDetailed> getHerbalDetailedsById(Integer id);
}
