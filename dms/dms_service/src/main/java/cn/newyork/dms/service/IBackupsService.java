package cn.newyork.dms.service;

import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Backups;
import cn.newyork.common.query.BackupsQuery;
import cn.newyork.core.service.IBaseService;

public interface IBackupsService extends IBaseService<Backups> {
    PageResult<Backups> queryPage(BackupsQuery query);
}
