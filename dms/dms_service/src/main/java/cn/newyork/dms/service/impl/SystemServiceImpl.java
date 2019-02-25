package cn.newyork.dms.service.impl;;


import cn.newyork.common.domain.System;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.SystemMapper;
import cn.newyork.dms.service.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: wenbing
 * @Date: 2018/10/17 14:45
 * @Version 1.0
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class SystemServiceImpl extends BaseServiceImpl<System> implements ISystemService {
    @Autowired
    private SystemMapper systemMapper;

    @Override
    protected BaseMapper<System> getMapper() {
        return systemMapper;
    }



//  事务测试
// @Transactional
//    @Override
//    public void add(System system) {
//        System.out.println("come on");
//        systemMapper.save(system);
//        int i=1/0;
//    }
}
