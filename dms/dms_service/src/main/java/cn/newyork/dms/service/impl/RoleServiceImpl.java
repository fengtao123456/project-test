package cn.newyork.dms.service.impl;;


import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Role;
import cn.newyork.common.query.RoleQuery;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.RoleMapper;
import cn.newyork.dms.service.IRoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    protected BaseMapper<Role> getMapper() {
        return roleMapper;
    }

    @Override
    public PageResult<Role> likeQuery(RoleQuery query) {
        //获取page对象（limit（query.getPage(),query.getRows()））
        Page<Role> objects = PageHelper.startPage(query.getPage(), query.getRows());
        //拿到模糊查询后的总数据
        roleMapper.likeQuery(query);//模糊查询
        //返回分页后的数据
        PageResult<Role> departmentPageResult = new PageResult<>(objects.getTotal(), objects.getResult());
        return departmentPageResult;
    }



}
