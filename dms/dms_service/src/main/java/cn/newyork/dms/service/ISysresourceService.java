package cn.newyork.dms.service;

import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Sysresource;
import cn.newyork.common.query.SysresourceQuery;
import cn.newyork.core.service.IBaseService;

public interface ISysresourceService extends IBaseService<Sysresource> {
     PageResult<Sysresource> likeQuery1(SysresourceQuery query);

}
