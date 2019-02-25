package cn.newyork.dms.service.impl;;


import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Sysresource;
import cn.newyork.common.query.SysresourceQuery;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.SysresourceMapper;
import cn.newyork.dms.service.ISysresourceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class SysresourceServiceImpl extends BaseServiceImpl<Sysresource> implements ISysresourceService {
    @Autowired
    private SysresourceMapper sysresourceMapper;
    @Override
    protected BaseMapper<Sysresource> getMapper() {
        return sysresourceMapper;
    }

    /**
     * 高级查询
     */
    //模糊查询
    @Override
    public PageResult<Sysresource> likeQuery1(SysresourceQuery query) {
        //获取page对象（limit（query.getPage(),query.getRows()））
        Page<Sysresource> objects = PageHelper.startPage(query.getPage(), query.getRows());
        //拿到模糊查询后的总数据
        sysresourceMapper.likeQuery(query);//模糊查询
        //返回分页后的数据
        PageResult<Sysresource> sysresourcePageResult = new PageResult<>(objects.getTotal(), objects.getResult());
        return sysresourcePageResult;
    }

}
