package cn.newyork.dms.service;

import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Permission;
import cn.newyork.common.query.PermissionQuery;
import cn.newyork.core.service.IBaseService;

import java.util.List;
import java.util.Set;

public interface IPermissionService extends IBaseService<Permission> {
    PageResult<Permission> likeQuery(PermissionQuery query);
    //根据用户的id查询权限
    Set<String> findSnByEmp(Long employeeId);
}
