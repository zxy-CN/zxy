package cn.his.mapper;

import cn.his.entity.Invoice;

public interface InvoiceMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 创建发票，这是发票对应的挂号id是0，一会儿用set方法赋值
     * @param invoice
     * @return
     */
    int insert(Invoice invoice);

    int insertSelective(Invoice record);

    Invoice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Invoice record);

    int updateByPrimaryKey(Invoice record);
}