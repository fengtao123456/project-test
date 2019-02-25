package cn.newyork.dms.service.impl;;


import cn.newyork.common.domain.${Domain};
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.${Domain}Mapper;
import cn.newyork.dms.service.I${Domain}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ${Domain}ServiceImpl extends BaseServiceImpl<${Domain}> implements I${Domain}Service {
    @Autowired
    private ${Domain}Mapper ${domain}Mapper;

    @Override
    protected BaseMapper<${Domain}> getMapper() {
        return ${domain}Mapper;
    }



//  事务测试
// @Transactional
//    @Override
//    public void add(${Domain} ${domain}) {
//        System.out.println("come on");
//        ${domain}Mapper.save(${domain});
//        int i=1/0;
//    }
}
