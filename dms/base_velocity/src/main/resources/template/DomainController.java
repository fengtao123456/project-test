package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.${Domain};
import cn.newyork.common.query.${Domain}Query;
import cn.newyork.dms.service.I${Domain}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/${domain}")
public class ${Domain}Controller {

    @Autowired
    private I${Domain}Service ${domain}Service;

    @RequestMapping("/index")
    public String index() {


        return "${domain}/${domain}";
    }

    @RequestMapping("/list")
    @ResponseBody//json
    public PageResult<${Domain}> list(${Domain}Query ${domain}Query) {

        return ${domain}Service.queryPage(${domain}Query);
    }

    // ${domain}/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            ${domain}Service.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // ${domain}/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(${Domain} ${domain}) {
        if (${domain} != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (${domain}.getId() != null) {
                    //修改
                    ${domain}Service.update(${domain});
                } else {
                    //添加
                    ${domain}Service.add(${domain});
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
