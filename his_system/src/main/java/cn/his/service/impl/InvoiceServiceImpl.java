package cn.his.service.impl;

import cn.his.entity.Invoice;
import cn.his.mapper.InvoiceMapper;
import cn.his.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service("invoiceService")
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceMapper invoiceMapper;

    @Override
    public int insert(Invoice invoice) {
        return invoiceMapper.insert(invoice);
    }

    @Override
    public Invoice selectByRegistID(Integer registId) {
        return invoiceMapper.selectByRegistID(registId);
    }

    @Override
    public Integer getCount() {
        return invoiceMapper.getCount();
    }

    @Override
    public int updateMoney(Invoice invoice) {
        return invoiceMapper.updateMoney(invoice);
    }

    @Override
    public int updateState5(Invoice invoice) {
        return invoiceMapper.updateState5(invoice);
    }

    @Override
    public int updateState6(Invoice invoice) {
        return invoiceMapper.updateState6(invoice);
    }

    @Override
    public HashMap selectMaxAndMin(HashMap map) {
        return invoiceMapper.selectMaxAndMin(map);
    }

    @Override
    public ArrayList<String> selectDel(HashMap map) {
        return invoiceMapper.selectDel(map);
    }

    @Override
    public ArrayList<String> selectAgain(HashMap map) {
        return invoiceMapper.selectAgain(map);
    }

    @Override
    public int updateDailyState(HashMap map) {
        return invoiceMapper.updateDailyState(map);
    }

    @Override
    public ArrayList<Invoice> selectlist(HashMap map) {
        return invoiceMapper.selectlist(map);
    }
}
