package cn.newyork.dms.mapper;

import cn.newyork.common.domain.Role;
import cn.newyork.common.query.RoleQuery;
import cn.newyork.core.mapper.BaseMapper;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    //模糊查询【角色名称】
    List<Role> likeQuery(RoleQuery roleQuery);
}