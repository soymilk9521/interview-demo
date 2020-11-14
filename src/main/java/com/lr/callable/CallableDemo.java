package com.lr.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-14 9:45
 * 创建线程的第三种方法
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 适配器模式，FutureTask实现了Runnable接口，构造函数传递Callable接口，Runnable和Callable产生练习
        FutureTask<Integer> task = new FutureTask<>(new MyThread());
        // FutureTask<Integer> task2 = new FutureTask<>(new MyThread());
        new Thread(task, "t1").start();
        // new Thread(task2, "t2").start();
        Integer i = 1024;
        Integer result = task.get(); // 建议放在最后，如果放在中间，main线程等待task返回，造成main线程阻塞；辅助记忆：串糖葫芦思想
        System.out.println(i + result);
        System.out.println(Thread.currentThread().getName() + "\t ************");
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        // try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) { e.printStackTrace();} // 模拟线程阻塞
        System.out.println(Thread.currentThread().getName() + "的call()方法被调用");
        return 1024;
    }
}
