package cn.newyork.dms.service;

import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Role;
import cn.newyork.common.query.RoleQuery;
import cn.newyork.core.service.IBaseService;

public interface IRoleService extends IBaseService<Role> {
    PageResult<Role> likeQuery(RoleQuery query);
}
