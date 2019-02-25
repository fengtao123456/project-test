package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Employee;
import cn.newyork.common.query.EmployeeQuery;
import cn.newyork.dms.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/index")
    public String index() {


        return "employee/employee";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult<Employee> list(EmployeeQuery employeeQuery) {

        return employeeService.queryPage(employeeQuery);
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Employee> queryAll( ) {

        return employeeService.getAll();
    }

    // employee/delete?id
    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        try {
            employeeService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // employee/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(Employee employee) {
        if (employee != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (employee.getId() != null) {
                    //修改
                    employeeService.update(employee);
                } else {
                    //添加
                    employeeService.add(employee);
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
