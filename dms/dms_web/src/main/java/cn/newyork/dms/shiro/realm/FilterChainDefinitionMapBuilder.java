package cn.newyork.dms.shiro.realm;

import cn.newyork.common.domain.Permission;
import cn.newyork.dms.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//获取到所有权限进行判断(权限判断)
public class FilterChainDefinitionMapBuilder {
    //注入service层的对象
    @Autowired
    private IPermissionService permissionService;
    //写一个方法 返回map
    public Map createFilterChainDefinitionMap(){

        Map mp = new LinkedHashMap();
        //以后操作数据 查询所有权限(交给shiro管理)
        //不需要权限访问的内容 ：/login=anon
        //注:对于一些不登录也可以放行的设置(大家可以根据实际情况添加)
        mp.put("/login","anon");
        mp.put("*.js","anon");
        mp.put("*.css","anon");
        mp.put("/static/css/**","anon");
        mp.put("/static/js/**","anon");
        mp.put("/static/js/easyui/**","anon");
        mp.put("/static/images/**","anon");
        //以下是需要权限进行访问（需要获取权限的url（资源的访问路径）和SN（相应的权限））
        //1.从数据库中查询所有权限
        List<Permission> permissions = permissionService.getAll();
        //2.遍历所有的权限
        for (Permission permission : permissions) {
            //把url（资源的访问路径）和SN（相应的权限）放到拦截中去
            //mp.put(permission.getUrl(), "dmsPerms["+permission.getSn()+"]");
            mp.put(permission.getSysresource().getUrl(), "dmsPerms["+permission.getSn()+"]");
        }
        //mp.put("/s/permission.jsp", "perms[user:*]");这个是写死的拦截
        mp.put("/**","authc");
        Set set = mp.entrySet();
        for (Object o : set) {
            System.out.println("map"+o.toString());
        }
        return mp;

    }


}
