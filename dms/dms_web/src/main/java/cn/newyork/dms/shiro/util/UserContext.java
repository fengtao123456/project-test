package cn.newyork.dms.shiro.util;

import cn.newyork.common.domain.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

//抽取一个工具类（目的设置与拿到当前用户）
public class UserContext {
    private static final String USER_IN_SESSION="loginUser";
    //设置当前用户的方法（设置当前用户shiro的session---分布式缓存）
    //把当前登陆用户放入session中
    public static void setUser(Employee loginUser){
        //拿到shiro的session
        Session session = SecurityUtils.getSubject().getSession();
        //设置session的key-value
        session.setAttribute(USER_IN_SESSION, loginUser);
    }
    //拿到当前用户的方法（从session中拿到当前用户）
    public static Employee getUser(){
        Session session = SecurityUtils.getSubject().getSession();
        //从session中获取当前用户
        Employee currentUser = (Employee) session.getAttribute(USER_IN_SESSION);
        return currentUser;
    }

}
