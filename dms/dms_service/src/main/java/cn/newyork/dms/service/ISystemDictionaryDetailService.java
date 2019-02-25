package cn.newyork.dms.service;

import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.SystemDictionaryDetail;
import cn.newyork.common.domain.SystemDictionaryDetailVo;
import cn.newyork.common.query.SystemDictionaryDetailQuery;
import cn.newyork.core.service.IBaseService;

import java.util.List;

public interface ISystemDictionaryDetailService extends IBaseService<SystemDictionaryDetail> {
    List<SystemDictionaryDetailVo> findItems(SystemDictionaryDetailQuery query);
    PageResult<SystemDictionaryDetail> likeQuery(SystemDictionaryDetailQuery query);

}
