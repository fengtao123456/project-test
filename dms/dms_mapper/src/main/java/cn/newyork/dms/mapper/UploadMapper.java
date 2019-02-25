package cn.newyork.dms.mapper;

import cn.newyork.common.domain.Upload;
import cn.newyork.core.mapper.BaseMapper;

import java.util.List;

public interface UploadMapper extends BaseMapper<Upload> {
    int deleteByPrimaryKey(Long id);

    int insert(Upload record);

    Upload selectByPrimaryKey(Long id);

    List<Upload> selectAll();

    int updateByPrimaryKey(Upload record);
}