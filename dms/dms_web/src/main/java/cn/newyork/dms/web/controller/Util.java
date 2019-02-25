package cn.newyork.dms.web.controller;

import cn.newyork.common.domain.Employee;
import cn.newyork.common.domain.Menu;
import cn.newyork.dms.service.IMenuService;
import cn.newyork.dms.shiro.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/util")
public class Util {

    @Autowired
    private IMenuService menuService;

    @RequestMapping("/main")
    public String index() {
        return "main";
    }

    @RequestMapping("/menu")
    @ResponseBody
    public List<Menu> menu() {
        List<Menu> all = menuService.findByLoginUser();
        return all;
    }

    //访问路径：/util/loginUserMenus
    //返回当前登录用户权限下tree菜单需要的数据（json格式）
    @RequestMapping("/loginUserMenus")
    @ResponseBody//返回json格式的数据
    public List loginUserMenus(Long id){
        System.out.println("进入controller层");
        Employee loginUser = UserContext.getUser();
        System.out.println("当前登录用户为："+loginUser);
        List<Menu> menus = menuService.findMenuByUser(loginUser.getId());
        System.out.println("菜单集合："+menus);
        for (Menu menu : menus) {
            System.out.println("根据当前登录用户拿到的菜单有："+menu);
        }
        return menus;
    }

}
