package com.lr.singleton;

import java.util.concurrent.*;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-15 7:54
 * 饿汉模式一，直接实例化
 */
public class Singleton1 {

    // public 向外公开实例
    // static 静态变量保存实例
    // final 强调
    public static final Singleton1 INSTANCE = new Singleton1();

    // 构造函数私有化
    private Singleton1() {
        System.out.println("单例模式 构造函数只执行一次");
    }

    public static void main(String[] args) {
        // 单例模式演示
        Singleton1 s1 = Singleton1.INSTANCE;
        Singleton1 s2 = Singleton1.INSTANCE;
        System.out.println(s1 == s2); // true

        // 枚举类特殊单例模式
        System.out.println(Singleton2.INSTANCE == Singleton2.INSTANCE); // true
    }
}
