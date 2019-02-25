package cn.newyork.dms.mapper;

import cn.newyork.common.domain.Menu;
import cn.newyork.core.mapper.BaseMapper;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> findAllChild();
    List<Menu> findParent();
    /*根据用户id获取所用的子菜单*/
    List<Menu> findManuByLoginUser(Long employeeId);
}