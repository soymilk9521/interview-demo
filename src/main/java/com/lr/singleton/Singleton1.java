package com.lr.singleton;

import java.util.concurrent.*;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-15 7:54
 */
public class Singleton1 {
    public static void main(String[] args) {
        // 单例模式演示
        Singleton1 s1 = Singleton1.INSTANCE;
        Singleton1 s2 = Singleton1.INSTANCE;
        System.out.println(s1 == s2); // true

        // 线程安全演示
        Callable<Singleton1> callable = () -> Singleton1.INSTANCE;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            Future<Singleton1> fu1 = executorService.submit(callable);
            Future<Singleton1> fu2 = executorService.submit(callable);
            Singleton1 s3 = fu1.get();
            Singleton1 s4 = fu2.get();
            System.out.println(s3 == s4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

        System.out.println(Singleton2.INSTANCE == Singleton2.INSTANCE);
    }

    // public 向外公开实例
    // static 静态变量保存实例
    // final 强调
    public static final Singleton1 INSTANCE = new Singleton1();
    static {
        try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
    }
    // 构造函数私有化
    private Singleton1() {
        System.out.println("单例模式 类加载中...");
    }
}
