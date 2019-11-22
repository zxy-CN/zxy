package cn.his.service.impl;

import cn.his.entity.FmedItem;
import cn.his.mapper.FmedItemMapper;
import cn.his.service.FmedItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service("fmedItemService")
public class FmedItemServiceImpl implements FmedItemService {
    @Autowired
    private FmedItemMapper fmedItemMapper;
    @Override
    public ArrayList<FmedItem> selectByName(String itemName) {
        return fmedItemMapper.selectByName(itemName);
    }

    @Override
    public PageInfo<FmedItem> findAll(int pageNum, int pageSize,String itemName) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<FmedItem> fmedItems=fmedItemMapper.selectByName(itemName);
        PageInfo<FmedItem> pageInfo=new PageInfo<FmedItem>(fmedItems);
        return pageInfo;
    }

    @Override
    public int insert(FmedItem fmedItem) {
        return fmedItemMapper.insert(fmedItem);
    }

    @Override
    public int updateById(FmedItem fmedItem) {
        return fmedItemMapper.updateById(fmedItem);
    }

    @Override
    public int deleteById(FmedItem fmedItem) {
        return fmedItemMapper.deleteById(fmedItem);
    }
}
