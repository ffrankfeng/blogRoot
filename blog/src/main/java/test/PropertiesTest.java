package test;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    private static final String config = "jgit.properties";
    //定义本地git路径
    public static  String LOCALPATH = "D:\\javaProgram\\JavaProgram4IDEA\\fengf\\repositories\\fengfRepository\\fengfRepository\\";
    //.git文件路径
    public static  String LOCALGITFILE = LOCALPATH + ".git";
    //远程仓库地址
    public static  String REMOTEREPOURI = "https://github.com/fengf96/fengfRepository.git";//操作git的用户名
    public static  String USER = "fengf96";
    //密码
    public static  String PASSWORD = "970805ff";

    @Test
    public void test(){
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties(config);
            LOCALPATH = properties.getProperty("jgit.localpath");
            System.out.println(properties.getProperty("jgit.localpath"));
            REMOTEREPOURI = properties.getProperty("jgit.remoterepouri");
            USER = properties.getProperty("jgit.user");
            PASSWORD = properties.getProperty("jgit.password");
            System.out.println(LOCALPATH+REMOTEREPOURI+USER+PASSWORD);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
