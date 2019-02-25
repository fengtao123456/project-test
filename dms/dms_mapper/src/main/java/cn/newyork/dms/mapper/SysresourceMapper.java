package cn.newyork.dms.mapper;

import cn.newyork.common.domain.Sysresource;
import cn.newyork.common.query.SysresourceQuery;
import cn.newyork.core.mapper.BaseMapper;

import java.util.List;

public interface SysresourceMapper extends BaseMapper<Sysresource> {
    List<Sysresource> likeQuery(SysresourceQuery query);
}