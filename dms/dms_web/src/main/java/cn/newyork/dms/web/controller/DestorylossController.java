package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Destoryloss;
import cn.newyork.common.query.DestorylossQuery;
import cn.newyork.dms.service.IDestorylossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/destoryloss")
public class DestorylossController {

    @Autowired
    private IDestorylossService destorylossService;

    @RequestMapping("/index")
    public String index() {


        return "destoryloss/destoryloss";
    }

    @RequestMapping("/list")
    @ResponseBody//json
    public PageResult<Destoryloss> list(DestorylossQuery destorylossQuery) {

        return destorylossService.queryPage(destorylossQuery);
    }

    // destoryloss/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            destorylossService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // destoryloss/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(Destoryloss destoryloss) {
        if (destoryloss != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (destoryloss.getId() != null) {
                    //修改
                    destorylossService.update(destoryloss);
                } else {
                    //添加
                    destorylossService.add(destoryloss);
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
