package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Permission;
import cn.newyork.common.query.PermissionQuery;
import cn.newyork.dms.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/index")
    public String index() {


        return "permission/permission";
    }

    @RequestMapping("/list")
    @ResponseBody//json
    public PageResult<Permission> list(PermissionQuery permissionQuery) {

        return permissionService.queryPage(permissionQuery);
    }
    //模糊查询
    @RequestMapping("/likeQuery")
    @ResponseBody//json
    public PageResult<Permission> likeQuery(PermissionQuery permissionQuery) {

        return permissionService.likeQuery(permissionQuery);
    }

    // permission/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            permissionService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // permission/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(Permission permission) {
        if (permission != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (permission.getId() != null) {
                    //修改
                    permissionService.update(permission);
                } else {
                    //添加
                    permissionService.add(permission);
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
