package cn.his.service;

import cn.his.entity.Department;

import java.util.ArrayList;

/**
 * 部门业务层接口
 */
public interface DepartmentService {
    /**
     * 挂号时查询挂号科室
     * @return
     */
    ArrayList<Department> selectRegDept();

}
