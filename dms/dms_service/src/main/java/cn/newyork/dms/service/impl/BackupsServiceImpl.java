package cn.newyork.dms.service.impl;;


import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Backups;
import cn.newyork.common.query.BackupsQuery;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.BackupsMapper;
import cn.newyork.dms.service.IBackupsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class BackupsServiceImpl extends BaseServiceImpl<Backups> implements IBackupsService {
    @Autowired
    private BackupsMapper backupsMapper;

    @Override
    protected BaseMapper<Backups> getMapper() {
        return backupsMapper;
    }

    @Override
    public PageResult<Backups> queryPage(BackupsQuery query) {
        System.out.println(query.getPage());
        System.out.println(query.getRows());
        //获取分页对象
        Page<Backups> objects = PageHelper.startPage(query.getPage(), query.getRows());
        //拿到分页后的总数据
        backupsMapper.queryPage(query);
        //返回分页后的结果（objects.getTotal()对应total,objects.getResult()对应rows）
        PageResult<Backups> backupsPageResult = new PageResult<>(objects.getTotal(), objects.getResult());
        System.out.println(backupsPageResult);
        return backupsPageResult;
    }


//  事务测试
// @Transactional
//    @Override
//    public void add(Backups backups) {
//        System.out.println("come on");
//        backupsMapper.save(backups);
//        int i=1/0;
//    }
}
