package cn.newyork.dms.service.impl;;


import cn.newyork.common.domain.SystemDictionaryType;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.IBaseService;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.SystemDictionaryTypeMapper;
import cn.newyork.dms.service.ISystemDictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class SystemDictionaryTypeServiceImpl extends BaseServiceImpl<SystemDictionaryType> implements ISystemDictionaryTypeService {
    @Autowired
    private SystemDictionaryTypeMapper systemDictionaryTypeMapper;

    @Override
    protected BaseMapper<SystemDictionaryType> getMapper() {
        return systemDictionaryTypeMapper;
    }



//  事务测试
// @Transactional
//    @Override
//    public void add(SystemDictionaryType systemDictionaryType) {
//        System.out.println("come on");
//        systemDictionaryTypeMapper.save(systemDictionaryType);
//        int i=1/0;
//    }
}
