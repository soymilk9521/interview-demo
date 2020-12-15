package com.lr.singleton;

import javax.rmi.CORBA.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-15 8:30
 *
 *  1. ClassName.class.getClassLoader().getResource("").getPath()// 获取claspath路径
 *  2. Maven资源文件编译路径设置
 *  3. 静态代码块随着类的加载而加载
 *  4. Properties加载属性文件
 *
 */
public class Singleton3 {
    private String info;
    public static final Singleton3 INSTANCE;
    static {
        System.out.println("静态代码块，加载中...");
        Properties properties = new Properties();
        try {
            System.out.println(Singleton3.class.getClassLoader().getResource("").getPath()); // classpath 路径
            ClassLoader loader = Singleton3.class.getClassLoader();
            InputStream input = loader.getResourceAsStream("single.properties");
            properties.load(input);
            System.out.println(properties.size());
            String key = properties.getProperty("com.lr.hello");
            System.out.println(key);
            INSTANCE = new Singleton3(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("单例模式，类加载异常");
        }
    }

    private Singleton3(String info) {
        this.info = info;
        System.out.println("单例模式，类加载中..." + info);
    }

    public static void main(String[] args) {
        Singleton3 s1 = Singleton3.INSTANCE;
        Singleton3 s2 = Singleton3.INSTANCE;
        System.out.println(s1 == s2);
    }
}
