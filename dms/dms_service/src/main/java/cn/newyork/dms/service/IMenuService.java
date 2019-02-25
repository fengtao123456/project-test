package cn.newyork.dms.service;

import cn.newyork.common.domain.Menu;
import cn.newyork.core.service.IBaseService;

import java.util.List;

public interface IMenuService extends IBaseService<Menu> {
    List<Menu> findByLoginUser();
    List<Menu> findParent();
    /*根据用户id获取菜单*/
    List<Menu> findMenuByUser(Long id);


}
