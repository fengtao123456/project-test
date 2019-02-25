package cn.newyork.dms.service.impl;

import cn.newyork.dms.service.IPermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class ServiceTest {
    @Autowired
    private IPermissionService permissionService;
    @Test
    public void test() throws Exception{
        Set<String> snByEmp = permissionService.findSnByEmp(1L);
        for (String s : snByEmp) {
            System.out.println(s);
        }
    }
}
