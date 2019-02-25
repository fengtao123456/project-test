package cn.newyork.dms.web.controller;

import cn.newyork.base.utils.AjaxResult;
import cn.newyork.common.domain.Employee;
import cn.newyork.dms.shiro.util.UserContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    //get方式进入该方法---用于跳转页面
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(){
        return "/login";
    }

    //登录提交进入方法（post）---用于登录
    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody//返回json格式的数据
    public AjaxResult login(String username, String password){

        /**
         * 获取当前的 Subject. 调用 SecurityUtils.getSubject();
         * 测试当前的用户是否已经被认证. 即是否已经登录. 调用 Subject 的 isAuthenticated()
         * 若没有被认证, 则把用户名和密码封装为 UsernamePasswordToken 对象
         * 执行登录: 调用 Subject 的 login(AuthenticationToken) 方法.
         */
        //1.拿到访问的主体(当前登录用户)
        Subject subject = SecurityUtils.getSubject();
        //2.判断这个用户是否已经登录(通过验证)
        if(!subject.isAuthenticated()){
            //3.如果没有验证，就要完成登录
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            try{
                //4.根据toke完成登录功能
                subject.login(token);
            }catch (UnknownAccountException e){
                System.out.println("用户名不存在！！");
                e.printStackTrace();
                return new AjaxResult("用户名不存在！！");
            }catch (IncorrectCredentialsException e){
                System.out.println("密码不存在！");
                e.printStackTrace();
                return new AjaxResult("密码不存在！");
            }catch (AuthenticationException e){
                System.out.println("登录出错！");
                e.printStackTrace();
                return new AjaxResult("登录出错！");
            }

        }
        //登录成功后把用户放到Session中
        //1.拿到当前登陆用户（主体）--jpaRealm中已经修改主题为Employee用户对象
        Employee currentUser = (Employee) subject.getPrincipal();
        //2.把当前用户放入session中
        UserContext.setUser(currentUser);
        return new AjaxResult();
    }

    //登出方法
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();//登出
        return "forward:/login";
    }

}

