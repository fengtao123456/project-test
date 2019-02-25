package cn.newyork.dms.log;

import cn.newyork.common.domain.Systemlog;
import cn.newyork.dms.mapper.SystemlogMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
@Component
public class WriteLog {
    @Autowired
    private SystemlogMapper systemlogMapper;

    public void end(JoinPoint point) {
//       System.out.println("被代理的对象"+point.getTarget());
//        System.out.println("代理的对象"+point.getThis());
//        System.out.println("传入的参数："+point.getArgs());
        Signature signature = point.getSignature();
        String method = signature.getName();
//        System.out.println("署名对象"+signature);
//        System.out.println("方法名："+signature.getName());
//        System.out.println("所属类："+signature.getDeclaringType());
//        System.out.println("所属类的类名："+signature.getDeclaringTypeName());
//        System.out.println("一串数字："+signature.getModifiers());
        Systemlog systemlog = new Systemlog();
        Date date = new Date();
        if("".equals(method) || method == null || "".equals(date) || date == null){
            return;
        }else if("insert".equals(method)||"updateByPrimaryKey".equals(method)||"deleteByPrimaryKey".equals(method)){
            systemlog.setFunction(method);
            systemlog.setDate(date);
            Object[] args = point.getArgs();
            for (Object arg : args) {
                if(arg instanceof Systemlog) {
                    return;
                }
            }
            String s = Arrays.toString(args);
            if(s.contains("{")){
                int i1 = s.indexOf("[");
                int i2 = s.indexOf("{");
                systemlog.setParams(s.substring(i1+1, i2));
            }else if(s.contains("@")){
                int i1 = s.lastIndexOf(".");
                int i2 = s.indexOf("@");
                systemlog.setParams(s.substring(i1+1,i2));
            }else {
                systemlog.setParams(s);
            }
            systemlog.setEmployee("ss");
            systemlogMapper.insert(systemlog);
        }else if("findAllChild".equals(method)){
            systemlog.setFunction("进入本系统");
            systemlog.setDate(date);
            systemlog.setEmployee("ss");
            systemlogMapper.insert(systemlog);
        }
//        System.err.println("............"+systemlog);

    }
}
