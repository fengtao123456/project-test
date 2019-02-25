package cn.newyork.dms.service.impl;;


import cn.newyork.common.domain.Password;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.PasswordMapper;
import cn.newyork.dms.service.IPasswordService;
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
public class PasswordServiceImpl extends BaseServiceImpl<Password> implements IPasswordService {
    @Autowired
    private PasswordMapper passwordMapper;

    @Override
    protected BaseMapper<Password> getMapper() {
        return passwordMapper;
    }



//  事务测试
// @Transactional
//    @Override
//    public void add(Password password) {
//        System.out.println("come on");
//        passwordMapper.save(password);
//        int i=1/0;
//    }
}
