package cn.newyork.dms.mapper;

import cn.newyork.common.domain.Archive;
import cn.newyork.core.mapper.BaseMapper;

import java.util.List;

public interface ArchiveMapper extends BaseMapper<Archive> {
    int deleteByPrimaryKey(Long id);

    int insert(Archive record);

    Archive selectByPrimaryKey(Long id);

    List<Archive> selectAll();

    int updateByPrimaryKey(Archive record);
}