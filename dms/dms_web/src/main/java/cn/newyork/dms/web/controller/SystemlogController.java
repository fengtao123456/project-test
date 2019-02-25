package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Systemlog;
import cn.newyork.common.query.SystemlogQuery;
import cn.newyork.core.mapper.BaseMapper;
import cn.newyork.dms.service.ISystemlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/systemlog")
public class SystemlogController {

    @Autowired
    private ISystemlogService systemlogService;
    @Autowired
    private BaseMapper<Systemlog> baseMapper;
    @RequestMapping("/index")
    public String index() {


        return "systemlog/systemlog";
    }

    @RequestMapping("/list")
    @ResponseBody//json
    public PageResult<Systemlog> list(SystemlogQuery systemlogQuery) {

        return systemlogService.queryPage(systemlogQuery);
    }

    // systemlog/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            systemlogService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // systemlog/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(Systemlog systemlog) {
        if (systemlog != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (systemlog.getId() != null) {
                    //修改
                    systemlogService.update(systemlog);
                } else {
                    //添加
                    systemlogService.add(systemlog);
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
