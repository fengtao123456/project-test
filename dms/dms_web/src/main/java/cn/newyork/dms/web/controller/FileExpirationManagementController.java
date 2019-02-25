package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.FileExpirationManagement;
import cn.newyork.common.query.FileExpirationManagementQuery;
import cn.newyork.dms.service.IFileExpirationManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/fileExpirationManagement")
public class FileExpirationManagementController {

    @Autowired
    private IFileExpirationManagementService fileExpirationManagementService;

    @RequestMapping("/index")
    public String index() {


        return "fileExpirationManagement/fileExpirationManagement";
    }

    @RequestMapping("/list")
    @ResponseBody//json
    public PageResult<FileExpirationManagement> list(FileExpirationManagementQuery fileExpirationManagementQuery) {

        return fileExpirationManagementService.queryPage(fileExpirationManagementQuery);
    }

    // fileExpirationManagement/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            fileExpirationManagementService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // fileExpirationManagement/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(FileExpirationManagement fileExpirationManagement) {
        if (fileExpirationManagement != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (fileExpirationManagement.getId() != null) {
                    //修改
                    fileExpirationManagementService.update(fileExpirationManagement);
                } else {
                    //添加
                    fileExpirationManagementService.add(fileExpirationManagement);
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
