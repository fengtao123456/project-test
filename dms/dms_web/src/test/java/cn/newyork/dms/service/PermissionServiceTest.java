package cn.newyork.dms.service;

import cn.newyork.common.domain.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PermissionServiceTest {
    @Autowired
    private IPermissionService permissionService;
    @Test
    public void testGetAll() throws Exception{
        List<Permission> permissions = permissionService.getAll();
        for (Permission permission : permissions) {
            System.out.println(permission.getSysresource().getUrl());
        }
    }
}
