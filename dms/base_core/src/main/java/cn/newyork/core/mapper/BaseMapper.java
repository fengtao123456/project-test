package cn.newyork.core.mapper;

import cn.newyork.core.query.BaseQuery;

import java.util.List;

public interface BaseMapper<T>{

    int deleteByPrimaryKey(Long id);

    int insert(T t);

    T selectByPrimaryKey(Long id);

    List<T> selectAll();

    int updateByPrimaryKey(T t);

    //分页:分页查询
    List<T> queryPage(BaseQuery baseQuery);

}
