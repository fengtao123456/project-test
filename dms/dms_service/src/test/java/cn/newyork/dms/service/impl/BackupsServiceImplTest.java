package cn.newyork.dms.service.impl;

import cn.newyork.common.domain.Backups;
import cn.newyork.dms.service.IBackupsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-service.xml")
public class BackupsServiceImplTest {
    @Autowired
    private IBackupsService backupsService;

    @Test
    public void getMapper() {
    }

    @Test
    public void add() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void get() {
    }

    @Test
    public void getAll() {
        List<Backups> all = backupsService.getAll();
        for (Backups backups : all) {
            System.out.println(backups);
        }
    }

    @Test
    public void queryPage() {
    }
}