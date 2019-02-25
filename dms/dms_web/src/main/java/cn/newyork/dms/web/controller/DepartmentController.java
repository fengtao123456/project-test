package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Department;
import cn.newyork.common.query.DepartmentQuery;
import cn.newyork.dms.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/index")
    public String index() {


        return "department/department";
    }

    @RequestMapping("/list")
    @ResponseBody//json
    public PageResult<Department> list(DepartmentQuery departmentQuery) {

        return departmentService.queryPage(departmentQuery);
    }

    @RequestMapping("/allParent")
    @ResponseBody
    public List<Department> allParent() {
        List<Department> all = departmentService.findGroup();
        return all;
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Department> all() {
        List<Department> all = departmentService.getAll();
        return all;
    }

    // department/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            departmentService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // department/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(Department department) {
        if (department != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (department.getId() != null) {
                    //修改
                    departmentService.update(department);
                } else {
                    //添加
                    departmentService.add(department);
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
