package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.SystemDictionaryType;
import cn.newyork.common.query.SystemDictionaryTypeQuery;
import cn.newyork.dms.service.ISystemDictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/systemDictionaryType")
public class SystemDictionaryTypeController {

    @Autowired
    private ISystemDictionaryTypeService systemDictionaryTypeService;

    @RequestMapping("/index")
    public String index() {


        return "systemDictionaryType/systemDictionaryType";
    }

    @RequestMapping("/list")
    @ResponseBody//json
    public PageResult<SystemDictionaryType> list(SystemDictionaryTypeQuery systemDictionaryTypeQuery) {

        return systemDictionaryTypeService.queryPage(systemDictionaryTypeQuery);
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<SystemDictionaryType> queryAll() {
        List<SystemDictionaryType> all = systemDictionaryTypeService.getAll();
        return all;
    }

    // systemDictionaryType/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            systemDictionaryTypeService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // systemDictionaryType/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(SystemDictionaryType systemDictionaryType) {
        if (systemDictionaryType != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (systemDictionaryType.getId() != null) {
                    //修改
                    systemDictionaryTypeService.update(systemDictionaryType);
                } else {
                    //添加
                    systemDictionaryTypeService.add(systemDictionaryType);
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
