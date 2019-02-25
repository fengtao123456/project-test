package cn.newyork.dms.service.impl;;


import cn.newyork.common.domain.Employee;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.EmployeeMapper;
import cn.newyork.dms.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    protected BaseMapper<Employee> getMapper() {
        return employeeMapper;
    }
    //根据用户名查询数据（用于登录认证）
    @Override
    public Employee findByUsername(String username) {
        Employee employee = employeeMapper.findByUsername(username);
        System.out.println(employee);
        return employee;
    }



}
