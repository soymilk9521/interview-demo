package com.lr.singleton;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-16 9:27
 * 懒汉模式二： 线程安全
 *
 */
public class Singleton5 {

    // 1. 构造函数私有化
    private Singleton5() {
        System.out.println("单例模式，构造函数只运行一次");
    }

    // 2. 静态私有变量，保存唯一的实例
    private static Singleton5 instance;

    // 3. 提供一个静态方法，获取类的实例
    public static Singleton5 getInstance() {

        if (instance == null) { // 双端检锁机制，提高效率
            synchronized (Singleton5.class) {
                if (instance == null) {
                    // 线程睡眠，模拟多线程环境
                    try {
                        TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
                    System.out.println("getInstance ---> " + Thread.currentThread().getName());
                    // 创建实例
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

    }
}
