package cn.newyork.dms.service;

import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Systemlog;
import cn.newyork.common.query.SystemlogQuery;
import cn.newyork.core.service.IBaseService;

public interface ISystemlogService extends IBaseService<Systemlog> {
    void updateIndex();
    PageResult<Systemlog> queryLog(SystemlogQuery query);
}
