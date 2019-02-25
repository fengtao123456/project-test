package cn.newyork.dms.mapper;

import cn.newyork.common.domain.Permission;
import cn.newyork.common.query.PermissionQuery;
import cn.newyork.core.mapper.BaseMapper;

import java.util.List;
import java.util.Set;

public interface PermissionMapper extends BaseMapper<Permission> {
    //模糊查询【权限名称与状态】
    List<Permission> likeQuery(PermissionQuery roleQuery);
    //根据用户的id查询权限
    Set<String> findSnByEmp(Long employeeId);
}