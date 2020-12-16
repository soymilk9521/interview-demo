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
        System.out.println("静态代码块，加载属性文件");
        Properties properties = new Properties();
        try {
            // 打印classpath路径
            System.out.println(Singleton3.class.getClassLoader().getResource("").getPath());
            // 创建类加载器
            ClassLoader loader = Singleton3.class.getClassLoader();
            // 通过类加载器将资源文件写入输入流
            InputStream input = loader.getResourceAsStream("single.properties");
            // properties加载资源文件
            properties.load(input);
            // 资源文件内容size
            System.out.println(properties.size());
            // 通过属性key，获取属性value
            String key = properties.getProperty("com.lr.hello");
            // 创建实例对象
            INSTANCE = new Singleton3(key);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("单例模式，资源文件加载异常");
        }
    }

    private Singleton3(String info) {
        this.info = info;
        System.out.println("单例模式，构造函数只执行一次");
    }

    public static void main(String[] args) {
        Singleton3 s1 = Singleton3.INSTANCE;
        Singleton3 s2 = Singleton3.INSTANCE;
        System.out.println(s1 == s2);
    }

    @Override
    public String toString() {
        return "Singleton3{" +
                "info='" + info + '\'' +
                '}';
    }
}
