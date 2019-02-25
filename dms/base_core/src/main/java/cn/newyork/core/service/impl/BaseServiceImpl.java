package cn.newyork.core.service.impl;


import cn.newyork.base.utils.PageResult;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.query.BaseQuery;
import cn.newyork.core.service.IBaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;

public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    protected abstract BaseMapper<T> getMapper();

    @Override
    public void add(T t) {
        getMapper().insert(t);
    }
    @Override
    public void delete(Long id) {
        getMapper().deleteByPrimaryKey(id);
    }

    @Override
    public void update(T t) {
        getMapper().updateByPrimaryKey(t);
    }

    @Override
    public T get(Long id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public List<T> getAll() {
        return getMapper().selectAll();
    }

    @Override
    public PageResult<T> queryPage(BaseQuery query) {
        //获取分页对象
        Page<T> objects = PageHelper.startPage(query.getPage(), query.getRows());
        //拿到分页后的总数据
        getMapper().queryPage(query);
        //返回分页后的结果（objects.getTotal()对应total,objects.getResult()对应rows）
        return new PageResult<>(objects.getTotal(), objects.getResult());
    }
}
