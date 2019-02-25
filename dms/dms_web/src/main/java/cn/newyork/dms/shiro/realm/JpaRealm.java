package cn.newyork.dms.shiro.realm;

import cn.newyork.common.domain.Employee;
import cn.newyork.dms.service.IEmployeeService;
import cn.newyork.dms.service.IPermissionService;
import cn.newyork.dms.shiro.util.UserContext;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 *  AuthenticatingRealm:只支持登录身份认证
 *  AuthorizingRealm:支持认证以及授权
 *
 */
/*完成权限的判断:通过当前登录用户拿到所有权限，然后去判断当前用户是否有咱们当前访问的这路径的权限！
    1.拿到登录用户:之前咱们登录，是把用户放到shiro中进行管理，现在我们先把主体修改成Employee用户：
                    主体改成当前登录用户

    */
public class JpaRealm extends AuthorizingRealm{
    //此对象用于身份认证
    @Autowired
    private IEmployeeService employeeService;
    //此对象用于权限判断
    @Autowired
    private IPermissionService permissionService;



    //完成身份的认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token1) throws AuthenticationException {
        //得到认证令牌
        UsernamePasswordToken token = (UsernamePasswordToken)token1;

        //完成认证 得到身份 (用户名)
        String username = token.getUsername();

        //根据用户去查询数据库 Employee
        Employee employee = employeeService.findByUsername(username);

          if(employee == null){
              return null;
          }
        //有用户名和密码就可以完成一个认证， principal表示当前主体或当前用户
        // Object principal = employee.getUsername();
          Object credentials = employee.getPassword();
          //盐值（字符串随便写）
        ByteSource salt = ByteSource.Util.bytes("newyork");
          //完成认证（此处已经把当前主体修改成了employee用户对象---在欢迎界面创建了）
        return new SimpleAuthenticationInfo(employee,credentials,salt,getName());
        //return new SimpleAuthenticationInfo(principal,credentials,salt,getName());
    }

    /**
     *  授权方法 doGetAuthorizationInfo
     *      给登录的用户授权权限
     *  进入此处进行权限判断
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {

        //拿到当前的主体(指的就是当前登录用户)
        Employee loginUser = UserContext.getUser();
        System.out.println("登录之后的主体用户:"+loginUser);
        //根据登录从数据库查询权限 给当前登录主体添加权限
        //根据登陆用户的id来查询权限
        Set<String> permissions = permissionService.findSnByEmp(loginUser.getId());
        for (String permission : permissions) {
            System.out.println(permission);
        }
        //拿到授权对象，并且所有权限交给它
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);
        //返回授权对象
        return simpleAuthorizationInfo;
    }
}
