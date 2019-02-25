package cn.newyork.dms.service.impl;;


import cn.newyork.common.domain.Upload;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.UploadMapper;
import cn.newyork.dms.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class UploadServiceImpl extends BaseServiceImpl<Upload> implements IUploadService {
    @Autowired
    private UploadMapper uploadMapper;

    @Override
    protected BaseMapper<Upload> getMapper() {
        return uploadMapper;
    }



//  事务测试
// @Transactional
//    @Override
//    public void add(Upload upload) {
//        System.out.println("come on");
//        uploadMapper.save(upload);
//        int i=1/0;
//    }
}
