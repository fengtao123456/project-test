package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.System;
import cn.newyork.common.query.SystemQuery;
import cn.newyork.dms.service.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: wenbing
 * @Date: 2018/10/17 22:52
 * @Version 1.0
 */
@Controller
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private ISystemService systemService;

    @RequestMapping("/index")
    public String index() {


        return "system/system";
    }

    @RequestMapping("/list")
    @ResponseBody//json
    public PageResult<System> list(SystemQuery systemQuery) {

        return systemService.queryPage(systemQuery);
    }

    // system/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            systemService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // system/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(System system) {
        if (system != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (system.getId() != null) {
                    //修改
                    systemService.update(system);
                } else {
                    //添加
                    systemService.add(system);
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
