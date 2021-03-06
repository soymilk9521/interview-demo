package com.lr.volatiledemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-04 8:03
 *
 * 1. 验证volatile的可见性
 * 2. 验证volatile不具备原子性
 *    2.1 原子性指的是，不可分割，完整性，即某个线程在做具体业务时，中间不可以加塞，不能被分割，需要整体完整
 *        要么同时成功要么同时失败。
 *    2.2 volatile 不保证原子性
 *
 *    2.3 volatile为什么不能保证原子性，字节码分析
 *
 *    2.4 如果解决原子性问题？
 *        - 加synchronized代码块
 *        - 使用juc包下的AtomicInteger
 */
public class VolatileDemo {
    public static void main(String[] args) {
        // volatile可见性演示
        // volatileVisibility();
        // volatile 非原子性演示
        volatileNonAtomic();

    }

    private static void volatileNonAtomic() {
        Mydata data = new Mydata();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    data.increment();
                    data.atomicAdd();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println("int type, The num value is " + data.num);
        System.out.println("AtomicInteger type, The atomicInteger value is " + data.atomicInteger);
    }

    /***
     * 可见性demo
     */
    private static void volatileVisibility() {
        Mydata data = new Mydata();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");
            try {
                TimeUnit.SECONDS.sleep(3);
                data.addto60();
                System.out.println(Thread.currentThread().getName() + " updated num value: " + data.num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread --- AAA").start();
        while (data.num == 0) {

        }
        System.out.println(Thread.currentThread().getName() + " mission is over, the num value is " + data.num);
    }

}

class Mydata{
    // volatile jvm轻量级的同步机制，保证线程间的可见性
    volatile int num = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public void addto60(){
        this.num = 60;
    }

    // public synchronized void increment() { // 解决原子性问题，但是杀鸡用牛刀
    public void increment() {
        this.num++;
    }

    // AtomicInteger提供原子操作的Integer的类
    public void atomicAdd() {
        atomicInteger.getAndIncrement();
    }
}