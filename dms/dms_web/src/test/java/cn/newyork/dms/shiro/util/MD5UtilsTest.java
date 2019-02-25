package cn.newyork.dms.shiro.util;

import cn.newyork.common.domain.Employee;
import cn.newyork.dms.mapper.EmployeeMapper;
import cn.newyork.dms.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MD5UtilsTest {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private IEmployeeService employeeService;
    @Test
    public void createMD5Str() {
        List<Employee> employees = employeeMapper.selectAll();
        for (Employee employee : employees) {
            employee.setPassword(MD5Utils.createMD5Str(employee.getPassword()));
            System.out.println(employee.getPassword());
            //添加一个用户就需要对密码经行加密（注意save方法是添加与修改的方法，所以在service层加密的时候需要进行判断）
            employeeService.update(employee);
        }
    }
}