package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.base.utils.PageResult;
import cn.newyork.common.domain.Password;
import cn.newyork.common.query.PasswordQuery;
import cn.newyork.dms.service.IPasswordService;
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
@RequestMapping("/password")
public class PasswordController {

    @Autowired
    private IPasswordService passwordService;

    @RequestMapping("/index")
    public String index() {


        return "password/password";
    }

    @RequestMapping("/list")
    @ResponseBody//json
    public PageResult<Password> list(PasswordQuery passwordQuery) {

        return passwordService.queryPage(passwordQuery);
    }

    // password/delete?id
    @RequestMapping("/delete")
    @ResponseBody//json
    public AjaxResult delete(Long id) {
        try {
            passwordService.delete(id);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("删除失败:" + e.getMessage());
        }
    }

    // password/saveOrUpdate
    @RequestMapping("/saveOrUpdate")
    @ResponseBody//json
    public AjaxResult saveOrUpdate(Password password) {
        if (password != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (password.getId() != null) {
                    //修改
                    passwordService.update(password);
                } else {
                    //添加
                    passwordService.add(password);
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
