package cn.newyork.dms.mapper;

import cn.newyork.common.domain.Employee;
import cn.newyork.core.mapper.BaseMapper;

import java.util.List;

public interface EmployeeMapper extends BaseMapper<Employee> {
    /*根据用户名查询数据*/
    Employee findByUsername(String username);
}