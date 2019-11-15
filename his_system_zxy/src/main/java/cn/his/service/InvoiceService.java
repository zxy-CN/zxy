package cn.his.service;

import cn.his.entity.Invoice;

/**
 * 发票的业务层接口
 */
public interface InvoiceService {

    /**
     * 创建发票，这是发票对应的挂号id是0，一会儿用set方法赋值
     * @param invoice
     * @return
     */
    int insert(Invoice invoice);
}
