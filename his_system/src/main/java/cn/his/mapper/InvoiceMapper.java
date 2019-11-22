package cn.his.mapper;

import cn.his.entity.Invoice;

import java.util.ArrayList;
import java.util.HashMap;

public interface InvoiceMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 创建发票，这是发票对应的挂号id是0，一会儿用set方法赋值
     * @param invoice
     * @return
     */
    int insert(Invoice invoice);

    /**
     * 查发票当前总数
     * @return
     */
    Integer getCount();

    int insertSelective(Invoice record);

    /**
     * 根据挂号id查发票
     * @param registId
     * @return
     */
    Invoice selectByRegistID(Integer registId);

    /**
     * 修改当前发票的消费金额以及发票打印状态为4
     * @param invoice
     * @return
     */
    int updateMoney(Invoice invoice);

    /**
     * 修改当前发票打印状态 已重打
     * @param invoice
     * @return
     */
    int updateState5(Invoice invoice);

    /**
     * 修改当前发票打印状态 已补打
     * @param invoice
     * @return
     */
    int updateState6(Invoice invoice);

    /**
     * 日结时修改日结状态
     * @param map
     * @return
     */
    int updateDailyState(HashMap map);

    /**查未作废的发票的起止号，以及总收入
     * @return
     */
    HashMap selectMaxAndMin(HashMap map);

    /**
     * 查作废的发票
     * @return
     */
    ArrayList<String> selectDel(HashMap map);

    /**
     * 查重打的发票
     * @return
     */
    ArrayList<String> selectAgain(HashMap map);

    /**
     * 查重每个病患的发票细节（日结查询）
     * @return
     */
    ArrayList<Invoice> selectlist(HashMap map);
}