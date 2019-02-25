package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.common.domain.SystemDictionaryDetail;
import cn.newyork.common.domain.SystemDictionaryDetailVo;
import cn.newyork.common.domain.SystemDictionaryType;
import cn.newyork.common.query.SystemDictionaryDetailQuery;
import cn.newyork.dms.service.ISystemDictionaryDetailService;
import cn.newyork.dms.service.ISystemDictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/systemDictionaryDetail")
public class SystemDictionaryDetailController {

    @Autowired
    private ISystemDictionaryDetailService systemDictionaryDetailService;
    @Autowired
    private ISystemDictionaryTypeService systemDictionaryTypeService;

    @RequestMapping("/index")
    public String index() {
        return "systemDictionaryDetail/systemDictionaryDetail";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map list(SystemDictionaryDetailQuery systemDictionaryDetailQuery) {
        Map<String,Object> map = new HashMap<>();
        List<SystemDictionaryDetailVo> items = systemDictionaryDetailService.findItems(systemDictionaryDetailQuery);
        map.put("rows", items);
        return map;
    }

@RequestMapping("/DocType")
    @ResponseBody
    public List<SystemDictionaryDetail> DocType() {
//    educdetail 找到所有的文档类型 文档类型为1
        return  systemDictionaryDetailService.getAllChildByType(1L);
    }
    @RequestMapping("/sex")
    @ResponseBody
    public List<SystemDictionaryDetail> sex() {
//    educdetail 找到所有的性别 性别类型号为
        return  systemDictionaryDetailService.getAllChildByType(2L);
    }
    @RequestMapping("/education")
    @ResponseBody
    public List<SystemDictionaryDetail> education() {
//    educdetail 找到所有的学历 学历类型号为3
        return  systemDictionaryDetailService.getAllChildByType(3L);
    }
    @RequestMapping("/borrowStatus")
    @ResponseBody
    public List<SystemDictionaryDetail> borrowStatus() {
//    educdetail 找到所有的借阅状态 借阅状态类型号为4
        return  systemDictionaryDetailService.getAllChildByType(4L);
    }
    @RequestMapping("/comeFromUtil")
    @ResponseBody
    public List<SystemDictionaryDetail> comeFromUtil() {
//    educdetail 找到所有的来文单元 来文单元类型号为5
        return  systemDictionaryDetailService.getAllChildByType(5L);
    }
    @RequestMapping("/comeFromDept")
    @ResponseBody
    public List<SystemDictionaryDetail> comeFromDept() {
//    educdetail 找到所有的来文部门 来文部门类型号为6
        return  systemDictionaryDetailService.getAllChildByType(6L);
    }
    @RequestMapping("/borrowIdenType")
    @ResponseBody
    public List<SystemDictionaryDetail> borrowIdenType() {
//    educdetail 找到所有的借阅人证件类型借阅人证件类型类型号为7
        return  systemDictionaryDetailService.getAllChildByType(7L);
    }
    @RequestMapping("/destoryReason")
    @ResponseBody
    public List<SystemDictionaryDetail> destoryReason() {
//    educdetail 找到所有的销毁原因 销毁原因类型号为8
        return  systemDictionaryDetailService.getAllChildByType(8L);
    }



    // systemDictionaryDetail/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            systemDictionaryDetailService.delete(id);
            systemDictionaryDetailService.delete(id);

            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // systemDictionaryDetail/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(SystemDictionaryDetail systemDictionaryDetail) {
        if (systemDictionaryDetail != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (systemDictionaryDetail.getId() != null) {
                    //修改
                    systemDictionaryDetailService.update(systemDictionaryDetail);
                } else {
                    //添加
                    systemDictionaryDetailService.add(systemDictionaryDetail);
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
