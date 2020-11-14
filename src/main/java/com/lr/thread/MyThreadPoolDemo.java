package com.lr.thread;

import java.util.concurrent.*;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-14 10:12
 * 创建线程的第四种方法
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        // 父接口
        // Executor executor = null;
        // 池化接口，不需要使用new关键字
        // ExecutorService service = Executors.newFixedThreadPool(5);
        // ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 10; i++) {
                service.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        }finally {
            service.shutdown();
        }

    }
}
