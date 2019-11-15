package cn.his.service.impl;

import cn.his.entity.Invoice;
import cn.his.mapper.InvoiceMapper;
import cn.his.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("invoiceService")
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceMapper invoiceMapper;

    @Override
    public int insert(Invoice invoice) {
        return invoiceMapper.insert(invoice);
    }
}
