package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Sysresource;
import cn.newyork.common.query.SysresourceQuery;
import cn.newyork.dms.service.ISysresourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sysResource")
public class SysresourceController {

    @Autowired
    private ISysresourceService sysresourceService;

    @RequestMapping("/index")
    public String index() {


        return "sysresource/sysresource";
    }

    @RequestMapping("/list")
    @ResponseBody//json
    public PageResult<Sysresource> list(SysresourceQuery sysresourceQuery) {

        return sysresourceService.queryPage(sysresourceQuery);
    }
    @RequestMapping("/likeQuery")
    @ResponseBody//json
    public PageResult<Sysresource> likeQuery(SysresourceQuery sysresourceQuery) {

        return sysresourceService.likeQuery1(sysresourceQuery);
    }

    // sysresource/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            sysresourceService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // sysresource/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(Sysresource sysresource) {
        if (sysresource != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (sysresource.getId() != null) {
                    //修改
                    sysresourceService.update(sysresource);
                } else {
                    //添加
                    sysresourceService.add(sysresource);
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
