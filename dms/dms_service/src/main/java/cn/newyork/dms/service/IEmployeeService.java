package cn.newyork.dms.service;

import cn.newyork.common.domain.Employee;
import cn.newyork.core.service.IBaseService;

public interface IEmployeeService extends IBaseService<Employee> {
    //根据用户名查询数据
    Employee findByUsername(String username);
}
