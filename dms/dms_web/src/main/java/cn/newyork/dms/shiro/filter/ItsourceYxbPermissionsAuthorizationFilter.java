package cn.newyork.dms.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*如果一个用户没有 删除员工权限，它去删除一个员工，出现删除失败，报undefined
    原因：
           shiro它对权限的处理：默认如果没有权限操作，返回的是一个没有权限操作的页面；而不是一个json的格式的字符串,
       （Ajax请求无法处理页面），故他的底层源码默认是找AuthorizationFilter的 onAccessDenied方法进行处理权限
    解决办法：
            1.不使用shiro的过滤器处理，我们自己写过滤器处理(在过滤器里面判断请求的类型，如果使用ajax请求，
         就直接返回json;如果不是就使用以前的处理返回页面（跳转页面--路径）
            2.区分是否是Ajax请求的关键在于判断请求头里面是否有X-Requested-With:XMLHttpRequest）。
*/


/*自定义权限过滤器（继承PermissionsAuthorizationFilter(此类继承了AuthorizationFilter)）
    要使用自定义权限过滤器就需要到shiro的配置文件去引用自定义的权限过滤器*/
public class ItsourceYxbPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {
    //覆写onAccessDenied方法

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {

        Subject subject = this.getSubject(request, response);
        if (subject.getPrincipal() == null) {
            //没有登陆成功的操作
            this.saveRequestAndRedirectToLogin(request, response);
        } else {
            //登陆成功的操作
            //1.强转请求响应对象（转成http的请求与响应操作）
            HttpServletRequest req = (HttpServletRequest)request;
            HttpServletResponse resp = (HttpServletResponse) response;
            //2.根据请求头区分是否是ajax请求
            String xmlHttpRequest = req.getHeader("X-Requested-With");
            if(xmlHttpRequest != null && "XMLHttpRequest".equals(xmlHttpRequest)){
                //3.当请求头为X-Requested-With且值为XMLHttpRequest就表示是Ajax请求
                //4.现在需要返回 json格式的数据{"success":false,"message":"没有权限"}
                resp.setContentType("text/json;charset=UTF-8");
                resp.getWriter().print("{\"success\":false,\"msg\":\"没有权限\"}");

            }else {
                //否则就是返回页面（跳转页面）--以前的默认操作
                String unauthorizedUrl = this.getUnauthorizedUrl();
                if (StringUtils.hasText(unauthorizedUrl)) {
                    WebUtils.issueRedirect(request, response, unauthorizedUrl);
                } else {
                    WebUtils.toHttp(response).sendError(401);
                }
            }

        }

        return false;

    }
}
