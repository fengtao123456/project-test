package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Role;
import cn.newyork.common.query.RoleQuery;
import cn.newyork.dms.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/index")
    public String index() {


        return "role/role";
    }

    @RequestMapping("/list")
    @ResponseBody//json
    public PageResult<Role> list(RoleQuery roleQuery) {

        return roleService.queryPage(roleQuery);
    }
    //模糊查询
    @RequestMapping("/likeQuery")
    @ResponseBody//json
    public PageResult<Role> likeQuery(RoleQuery roleQuery) {

        return roleService.likeQuery(roleQuery);
    }

    // role/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            roleService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // role/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(Role role) {
        if (role != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (role.getId() != null) {
                    //修改
                    roleService.update(role);
                } else {
                    //添加
                    roleService.add(role);
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
