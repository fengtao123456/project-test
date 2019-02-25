package cn.newyork.dms.service.impl;;


import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.SystemDictionaryDetail;
import cn.newyork.common.domain.SystemDictionaryDetailVo;
import cn.newyork.common.domain.SystemDictionaryType;
import cn.newyork.common.query.SystemDictionaryDetailQuery;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.SystemDictionaryDetailMapper;
import cn.newyork.dms.service.ISystemDictionaryDetailService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class SystemDictionaryDetailServiceImpl extends BaseServiceImpl<SystemDictionaryDetail> implements ISystemDictionaryDetailService {
    @Autowired
    private SystemDictionaryDetailMapper systemDictionaryDetailMapper;

    @Override
    protected BaseMapper<SystemDictionaryDetail> getMapper() {
        return systemDictionaryDetailMapper;
    }

    /**
     *
     * @return 构造dataView的数据
     */
    /*@Override
    public List<SystemDictionaryDetailVo> findItems() {
        List<SystemDictionaryDetailVo> detailVos = new ArrayList<>();
        List<SystemDictionaryDetail> details = systemDictionaryDetailMapper.selectAll();
        for (SystemDictionaryDetail detail : details) {
            SystemDictionaryType types = detail.getTypes();
            SystemDictionaryDetailVo vo = new SystemDictionaryDetailVo(detail, types);
            detailVos.add(vo);
        }
        return detailVos;
    }*/
    @Override
    public List<SystemDictionaryDetailVo> findItems(SystemDictionaryDetailQuery query) {
        List<SystemDictionaryDetailVo> detailVos = new ArrayList<>();
        List<SystemDictionaryDetail> details = systemDictionaryDetailMapper.likeQuery(query);
        for (SystemDictionaryDetail detail : details) {
            SystemDictionaryType types = detail.getTypes();
            SystemDictionaryDetailVo vo = new SystemDictionaryDetailVo(detail, types);
            detailVos.add(vo);
        }
        return detailVos;
    }
    //模糊查询
    @Override
    public PageResult<SystemDictionaryDetail> likeQuery(SystemDictionaryDetailQuery query) {
        //获取page对象（limit（query.getPage(),query.getRows()））
        Page<SystemDictionaryDetail> objects = PageHelper.startPage(query.getPage(), query.getRows());
        //拿到模糊查询后的总数据
        systemDictionaryDetailMapper.likeQuery(query);//模糊查询
        //返回分页后的数据
        PageResult<SystemDictionaryDetail> sysresourcePageResult = new PageResult<>(objects.getTotal(), objects.getResult());
        return sysresourcePageResult;
    }



}
