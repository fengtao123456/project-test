package cn.newyork.dms.mapper;

import cn.newyork.common.domain.System;
import cn.newyork.core.mapper.BaseMapper;

import java.util.List;

public interface SystemMapper extends BaseMapper<System> {
    int deleteByPrimaryKey(Long id);

    int insert(System record);

    System selectByPrimaryKey(Long id);

    List<System> selectAll();

    int updateByPrimaryKey(System record);
}