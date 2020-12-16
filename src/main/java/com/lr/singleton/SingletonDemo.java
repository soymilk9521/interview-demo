package com.lr.singleton;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-05 9:21
 */
public class SingletonDemo {

    private static volatile SingletonDemo instance;

    private  SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法 SingletonDemo()");
    }

    // public static synchronized SingletonDemo getInstance() { // 使用synchronize的关键字可以解决多线程单例模式问题，但不推荐！
    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class){
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        // 单线程操作单例模式：没有问题
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//
//
//        System.out.println();
//        System.out.println();
//        System.out.println();


        // 多线程操作单例模式：存在问题
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                SingletonDemo.getInstance(); // 多线程环境下构造方法执行多次
            }, String.valueOf(i)).start();
        }

        System.out.println("=============================");

        Singleton6 s1 = Singleton6.getInstance();
        Singleton6 s2 = Singleton6.getInstance();
        System.out.println(s1 == s2);

    }


}
