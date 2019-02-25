package cn.newyork.dms.mapper;

import cn.newyork.common.domain.Backups;
import cn.newyork.common.query.BackupsQuery;
import cn.newyork.core.mapper.BaseMapper;

import java.util.List;

public interface BackupsMapper extends BaseMapper<Backups> {
    List<Backups> queryPage(BackupsQuery query);
}