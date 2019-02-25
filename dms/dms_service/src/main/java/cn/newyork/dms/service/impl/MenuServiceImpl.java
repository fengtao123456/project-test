package cn.newyork.dms.service.impl;

import cn.newyork.common.domain.Employee;
import cn.newyork.common.domain.Menu;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.core.service.impl.BaseServiceImpl;
import cn.newyork.dms.mapper.MenuMapper;
import cn.newyork.dms.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements IMenuService {

    /**
     * parents 父菜单
     * All 所有的菜单，有权限模块后需要根据id查询出权限
     */
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findByLoginUser() {
        //自己创建一个parents来存储
        List<Menu> parents=new ArrayList<>();
        List<Menu> children = menuMapper.findAllChild();
        for (Menu child : children) {
            Menu parent = child.getParent();
            if(!parents.contains(parent)){
                parents.add(parent);
            }
            parent.getChildren().add(child);
        }
        return parents;
    }

    @Override
    public List<Menu> findParent() {
        return menuMapper.findParent();
    }

    @Override
    public List<Menu> findMenuByUser(Long id) {
        System.out.println("进入service层");
        //拿到当前登录账户
        Employee employee =(Employee) UserContext.getUser();
        System.out.println("当前登录用户为："+employee);
        //根据账户拿到所以子菜单
        List<Menu> childrenMenus = menuMapper.findManuByLoginUser(employee.getId());
        System.out.println("子菜单对象："+childrenMenus);
        //准备一个父菜单
        List<Menu> parentsMenu = new ArrayList();
        //遍历子菜单，(如有父菜单 放入进去）
        for (Menu childMenu : childrenMenus){
            //拿到子菜单 对应的父菜单
            Menu parent = childMenu.getParent();
            //如果父菜单里面没有父菜单 ，则放入
            if(!parentsMenu.contains(parent)){
                parentsMenu.add(parent);
            }
            //把当前遍历的子菜单放入父菜单里面
            parent.getChildren().add(childMenu);
        }

        return parentsMenu;
    }



    @Override
    protected BaseMapper<Menu> getMapper() {
        return menuMapper;
    }


}
