package com.lr.singleton;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-17 8:13
 * 单懒汉模式三： 线程安全（静态内部类）
 */
public class Singleton6 {
    // 构造函数私有化
    private Singleton6() {
        System.out.println("单例模式，构造函数只运行一次");
    }

    // 通过静态内部类，创建实例
    // *** 静态内部类不会随着，外部类的加载和初始化而初始化，他是要单独加载和初始化的 ***
    private static class Inner {
        public Inner(){
            System.out.println("匿名内部类构造函数执行"); // 不会执行
        }
        public static final Singleton6 INSTANCE = new Singleton6();
    }

    //  公开获得实例的静态方法
    public static Singleton6 getInstance(){
        return Inner.INSTANCE;
    }
}
