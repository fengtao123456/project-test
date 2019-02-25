package cn.newyork.dms.shiro.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

//准备一个加密算法的工具类
public class MD5Utils {
    //String algorithmName, Object source, Object salt, int hashIterations
    //加密算法名称
    public static final String algorithmName = "MD5";
    //遍历的次数（加密次数）
    public static final int  hashIterations = 10;

    //产生一个密码的工具类
    public static String createMD5Str(String password){
        //设置盐值
        ByteSource salt = ByteSource.Util.bytes("newyork");
        //加密加盐
        SimpleHash simpleHash = new SimpleHash(algorithmName, password, salt, hashIterations);

        return simpleHash.toString();
    }

}
