package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Menu;
import cn.newyork.common.query.MenuQuery;
import cn.newyork.dms.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @RequestMapping("/index")
    public String index() {


        return "menu/menu";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Menu> list() {
        List<Menu> all = menuService.findByLoginUser();
        return all;
    }

    @RequestMapping("/Parent")
    @ResponseBody
    public List<Menu> findParent() {
        List<Menu> parents = menuService.findParent();
        return parents;
    }

    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            menuService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // menu/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(Menu menu) {
        if (menu != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (menu.getId() != null) {
                    //修改
                    menuService.update(menu);
                } else {
                    //添加
                    menuService.add(menu);
                }
                return new AjaxResult();
            } catch (Exception e) {
                e.printStackTrace();
                return new AjaxResult("操作失败:"+e.getMessage());
            }
        }
        return null;
    }
}
