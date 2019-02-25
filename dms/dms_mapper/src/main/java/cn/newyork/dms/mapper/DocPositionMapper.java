package cn.newyork.dms.mapper;

import cn.newyork.common.domain.DocPosition;
import java.util.List;

public interface DocPositionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DocPosition record);

    DocPosition selectByPrimaryKey(Long id);

    List<DocPosition> selectAll();

    int updateByPrimaryKey(DocPosition record);
}