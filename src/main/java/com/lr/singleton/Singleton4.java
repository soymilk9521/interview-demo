package com.lr.singleton;

import java.util.concurrent.*;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-16 8:40
 * 单懒汉模式一： 线程不安全
 */
public class Singleton4 {

    // 1. 构造函数私有化
    private Singleton4() {
        System.out.println("单例模式，构造函数只运行一次");
    }

    // 2. 静态私有变量，保存唯一的实例
    private static Singleton4 instance;

    // 3. 提供一个静态方法，获取类的实例
    public static Singleton4 getInstance() {
        if (instance == null) {
            // 线程睡眠，模拟多线程环境
            try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
            System.out.println("getInstance ---> " + Thread.currentThread().getName());
            // 创建实例
            instance = new Singleton4();
        }
        return instance;
    }
    public static void main(String[] args) {
        // 单例模式演示，构造函数只运行一次
        Singleton4 s1 = Singleton4.getInstance();
        Singleton4 s2 = Singleton4.getInstance();
        System.out.println("单线程环境：" + (s1 == s2)); // true
    }


}
