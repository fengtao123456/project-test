package cn.newyork.dms.service.impl;;


import cn.newyork.common.domain.FileExpirationManagement;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.FileExpirationManagementMapper;
import cn.newyork.dms.service.IFileExpirationManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class FileExpirationManagementServiceImpl extends BaseServiceImpl<FileExpirationManagement> implements IFileExpirationManagementService {
    @Autowired
    private FileExpirationManagementMapper fileExpirationManagementMapper;

    @Override
    protected BaseMapper<FileExpirationManagement> getMapper() {
        return fileExpirationManagementMapper;
    }



//  事务测试
// @Transactional
//    @Override
//    public void add(FileExpirationManagement fileExpirationManagement) {
//        System.out.println("come on");
//        fileExpirationManagementMapper.save(fileExpirationManagement);
//        int i=1/0;
//    }
}
