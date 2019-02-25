package cn.newyork.dms.service.impl;

import cn.newyork.dms.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class EmployeeServiceImplTest {
    @Autowired
    private IEmployeeService employeeService;

    @Test
    public void findByUsername() {
        System.out.println(employeeService);
        System.out.println(employeeService.findByUsername("ft"));
    }
}