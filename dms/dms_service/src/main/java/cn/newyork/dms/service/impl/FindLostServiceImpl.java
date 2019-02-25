package cn.newyork.dms.service.impl;;


import cn.newyork.common.domain.FindLost;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.FindLostMapper;
import cn.newyork.dms.service.IFindLostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class FindLostServiceImpl extends BaseServiceImpl<FindLost> implements IFindLostService {
    @Autowired
    private FindLostMapper findLostMapper;

    @Override
    protected BaseMapper<FindLost> getMapper() {
        return findLostMapper;
    }



//  事务测试
// @Transactional
//    @Override
//    public void add(FindLost findLost) {
//        System.out.println("come on");
//        findLostMapper.save(findLost);
//        int i=1/0;
//    }
}
