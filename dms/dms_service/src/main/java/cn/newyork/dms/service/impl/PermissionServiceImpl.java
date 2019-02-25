package cn.newyork.dms.service.impl;;


import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Permission;
import cn.newyork.common.query.PermissionQuery;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.PermissionMapper;
import cn.newyork.dms.service.IPermissionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    protected BaseMapper<Permission> getMapper() {
        return permissionMapper;
    }

    @Override
    public PageResult<Permission> likeQuery(PermissionQuery query) {
        //获取page对象（limit（query.getPage(),query.getRows()））
        Page<Permission> objects = PageHelper.startPage(query.getPage(), query.getRows());
        //拿到模糊查询后的总数据
        permissionMapper.likeQuery(query);//模糊查询
        //返回分页后的数据
        PageResult<Permission> departmentPageResult = new PageResult<>(objects.getTotal(), objects.getResult());
        return departmentPageResult;
    }
    //根据用户的id查询权限sn
    @Override
    public Set<String> findSnByEmp(Long employeeId) {
        Set<String> stringSet = permissionMapper.findSnByEmp(employeeId);
        for (String s : stringSet) {
            System.out.println("permissionService="+s);
        }
        return stringSet;
    }


}
