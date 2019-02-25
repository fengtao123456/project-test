package cn.newyork.dms.service.impl;;


import cn.newyork.common.domain.Destoryloss;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.DestorylossMapper;
import cn.newyork.dms.service.IDestorylossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class DestorylossServiceImpl extends BaseServiceImpl<Destoryloss> implements IDestorylossService {
    @Autowired
    private DestorylossMapper destorylossMapper;

    @Override
    protected BaseMapper<Destoryloss> getMapper() {
        return destorylossMapper;
    }



//  事务测试
// @Transactional
//    @Override
//    public void add(Destoryloss destoryloss) {
//        System.out.println("come on");
//        destorylossMapper.save(destoryloss);
//        int i=1/0;
//    }
}
