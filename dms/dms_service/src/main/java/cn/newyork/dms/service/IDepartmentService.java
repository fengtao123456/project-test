package cn.newyork.dms.service;

import cn.newyork.common.domain.Department;
import cn.newyork.common.query.DepartmentQuery;
import cn.newyork.core.service.IBaseService;

import java.util.List;

public interface IDepartmentService extends IBaseService<Department> {
    List<Department> findGroup();
    List<Department> findGroup(DepartmentQuery departmentQuery);
}

