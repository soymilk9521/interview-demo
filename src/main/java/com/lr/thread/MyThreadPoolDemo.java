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
        // testJKDExecutors();
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1l,
                 TimeUnit.SECONDS,
                 new LinkedBlockingDeque<Runnable>(3),
                 Executors.defaultThreadFactory(),
                 // new ThreadPoolExecutor.AbortPolicy()); // 超出corePoolSize+workQueue的和的任务直接抛出异常
                 // new ThreadPoolExecutor.CallerRunsPolicy()); // 超出corePoolSize+workQueue的和的任务交给调用者main运行
                 // new ThreadPoolExecutor.DiscardOldestPolicy()); // 8和9代替前面某个等待时间最久的任务，直接执行
                 new ThreadPoolExecutor.DiscardPolicy()); // 8和9任务直接被抛弃
        try {
            for (int i = 0; i < 10; i++) {
                final int tempInt = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务 ----> " + tempInt);
                });
            }
        }finally {
            threadPool.shutdown();
        }


    }

    private static void testJKDExecutors() {
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
