package com.lr.singleton;

import java.util.concurrent.*;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-16 9:22
 * 1.懒汉式单例模式一: 线程不安全演示
 * 2.懒汉式单例模式二: 线程安全演示（双端检锁机制）
 */
public class SingletonMulThreadTest {
    public static void main(String[] args) {
        // 演示线程不安全（懒汉式单例模式）
        Callable callable = () -> {
            System.out.println("callable ---> " + Thread.currentThread().getName());
//            return Singleton4.getInstance();
            return Singleton5.getInstance();
        };
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 提交线程池任务
//        Future<Singleton4> f1 = executorService.submit(callable);
//        Future<Singleton4> f2 = executorService.submit(callable);
        Future<Singleton5> f1 = executorService.submit(callable);
        Future<Singleton5> f2 = executorService.submit(callable);
        try {
            // 获取线程操作资源
//            Singleton4 s3 = f1.get();
//            Singleton4 s4 = f2.get();
            Singleton5 s3 = f1.get();
            Singleton5 s4 = f2.get();
            System.out.println("多线程环境：" + (s3 == s4)); // false
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown(); // 关闭线程池
        }
    }
}
