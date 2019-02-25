package cn.newyork.dms.mapper;

import cn.newyork.common.domain.SystemDictionaryDetail;
import cn.newyork.common.query.SystemDictionaryDetailQuery;
import cn.newyork.core.mapper.BaseMapper;

import java.util.List;

public interface SystemDictionaryDetailMapper extends BaseMapper<SystemDictionaryDetail> {
    /*模糊查询【字典标识和字典类型模糊查询】*/
    List<SystemDictionaryDetail> likeQuery(SystemDictionaryDetailQuery query);
}