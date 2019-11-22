package cn.his.mapper;

import cn.his.entity.Department;

import java.util.ArrayList;

public interface DepartmentMapper {
    /**
     * 挂号时查询挂号科室
     * @return
     */
    ArrayList<Department> selectRegDept();
}