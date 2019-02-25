package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.FindLost;
import cn.newyork.common.query.FindLostQuery;
import cn.newyork.dms.service.IFindLostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/findLost")
public class FindLostController {

    @Autowired
    private IFindLostService findLostService;

    @RequestMapping("/index")
    public String index() {


        return "findLost/findLost";
    }

    @RequestMapping("/list")
    @ResponseBody//json
    public PageResult<FindLost> list(FindLostQuery findLostQuery) {

        return findLostService.queryPage(findLostQuery);
    }

    // findLost/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            findLostService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // findLost/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(FindLost findLost) {
        if (findLost != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (findLost.getId() != null) {
                    //修改
                    findLostService.update(findLost);
                } else {
                    //添加
                    findLostService.add(findLost);
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
