package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Backups;
import cn.newyork.common.query.BackupsQuery;
import cn.newyork.dms.service.IBackupsService;
import cn.newyork.dms.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/backups")
public class BackupsController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IBackupsService backupsService;

    @RequestMapping("/index")
    public String index() {


        return "backups/backups";
    }

    @RequestMapping("/list")
    @ResponseBody//json
    public PageResult<Backups> list(BackupsQuery backupsQuery) {
        return backupsService.queryPage(backupsQuery);
    }
    // backups/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            backupsService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // backups/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(Backups backups) {
        System.out.println(backups);
        if (backups != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (backups.getId() != null) {
                    //修改
                    backupsService.update(backups);
                } else {
                    //添加
                    backupsService.add(backups);
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
