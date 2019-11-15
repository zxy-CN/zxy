package cn.his.service.impl;

import cn.his.entity.Department;
import cn.his.mapper.DepartmentMapper;
import cn.his.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public ArrayList<Department> selectRegDept() {
        return departmentMapper.selectRegDept();
    }
}
