package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Archive;
import cn.newyork.common.query.ArchiveQuery;
import cn.newyork.dms.service.IArchiveService;
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
@RequestMapping("/archive")
public class ArchiveController {

    @Autowired
    private IArchiveService archiveService;

    @RequestMapping("/index")
    public String index() {


        return "archive/archive";
    }

    @RequestMapping("/list")
    @ResponseBody//json
    public PageResult<Archive> list(ArchiveQuery archiveQuery) {

        return archiveService.queryPage(archiveQuery);
    }

    // archive/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            archiveService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // archive/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(Archive archive) {
        if (archive != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (archive.getId() != null) {
                    //修改
                    archiveService.update(archive);
                } else {
                    //添加
                    archiveService.add(archive);
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
