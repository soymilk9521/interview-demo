package com.lr.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-07 11:57
 */
public class ABADemo {
    public static void main(String[] args) {
        // CAS产生ABA问题代码演示
        // showABA();
        // 使用时间戳原子引用更新类解决CAS的ABA问题
        shootABA();
    }

    private static void shootABA() {
        AtomicStampedReference<Integer> atomicReference = new AtomicStampedReference<>(5, 1);
        new Thread(()->{
            System.out.println("初始时间戳为：" + atomicReference.getStamp());
            System.out.println(Thread.currentThread().getName() +"\t" + atomicReference.compareAndSet(5, 6, 1, atomicReference.getStamp() + 1) + "\t value= " + atomicReference.getReference().intValue());
            System.out.println("第一次更新后时间戳为：" + atomicReference.getStamp());
            System.out.println(Thread.currentThread().getName() +"\t" + atomicReference.compareAndSet(6, 5, 2, atomicReference.getStamp() + 1) + "\t value= " + atomicReference.getReference().intValue());
            System.out.println("第二次更新后时间戳为：" + atomicReference.getStamp());
        }, "T1").start();

        try {
            TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
        System.out.println("=========================");
        new Thread(()->{
            System.out.println("初始时间戳为：" + atomicReference.getStamp());
            System.out.println(Thread.currentThread().getName() +"\t" + atomicReference.compareAndSet(5, 2019, 1, atomicReference.getStamp() + 1) + "\t value= " + atomicReference.getReference().intValue());
        }, "T2").start();
    }

    private static void showABA() {
        AtomicReference<Integer> atomicReference = new AtomicReference<>(5);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() +"\t" + atomicReference.compareAndSet(5, 6) + "\t value= " + atomicReference.get());
            System.out.println(Thread.currentThread().getName() +"\t" + atomicReference.compareAndSet(6, 5) + "\t value= " + atomicReference.get());
        }, "T1").start();

        try {
            TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
        System.out.println("=========================");
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() +"\t" + atomicReference.compareAndSet(5, 2019) + "\t value= " + atomicReference.get());
        }, "T2").start();
    }
}
