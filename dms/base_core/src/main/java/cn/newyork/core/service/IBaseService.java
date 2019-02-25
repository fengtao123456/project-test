package cn.newyork.core.service;

import cn.newyork.base.utils.PageResult;
import cn.newyork.core.query.BaseQuery;

import java.util.List;

public interface IBaseService<T>{

    void add(T t);

    void delete(Long id);

    void update(T t);

    T get(Long id);

    List<T> getAll();

    /**根据分页条件返回查询结果
     * @param query
     * @return
     */
    PageResult<T> queryPage(BaseQuery query);
}
