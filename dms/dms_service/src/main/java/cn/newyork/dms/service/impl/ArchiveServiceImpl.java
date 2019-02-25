package cn.newyork.dms.service.impl;;


import cn.newyork.common.domain.Archive;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.ArchiveMapper;
import cn.newyork.dms.service.IArchiveService;
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
public class ArchiveServiceImpl extends BaseServiceImpl<Archive> implements IArchiveService {
    @Autowired
    private ArchiveMapper archiveMapper;

    @Override
    protected BaseMapper<Archive> getMapper() {
        return archiveMapper;
    }



//  事务测试
// @Transactional
//    @Override
//    public void add(Archive archive) {
//        System.out.println("come on");
//        archiveMapper.save(archive);
//        int i=1/0;
//    }
}
