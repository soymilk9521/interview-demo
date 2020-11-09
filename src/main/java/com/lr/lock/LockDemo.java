package com.lr.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-08 21:37
 * 可重入锁（递归锁）,指的是当一个线程外层函数获得锁之后，内存递归函数仍然能获取该锁的代码
 * 在同一个线程在外层方法获取锁的时候，在进入内层方法时会自动获取锁
 * 也即是说，线程可以进入任意一个已经拥有锁所同步的代码块
 * Synchronized/ReentrantLock都是可重入锁
 */
public class LockDemo {
    public static void main(String[] args) {
//        AtomicInteger atomicInteger = new AtomicInteger(0);
//        do {
//            atomicInteger.getAndIncrement();
//            System.out.println(atomicInteger.get());
//        }while (!atomicInteger.compareAndSet(5, 2019));
        // Synchronized演示
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendMsn();
        }, "t1").start();
        new Thread(()->{
            phone.sendMsn();
        }, "t2").start();

        try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        // ReentrantLock演示
        Thread t3 = new Thread(phone, "t3");
        t3.start();
        Thread t4 = new Thread(phone, "t4");
        t4.start();

    }
}

class Phone implements Runnable{
    public synchronized void sendMsn(){
        System.out.println(Thread.currentThread().getName() + " sendMsn");
        sendMessage();
    }
    public synchronized void sendMessage() {
        System.out.println(Thread.currentThread().getName() + " #### sendMessage");
    }

    @Override
    public void run() {
        get();
    }
    Lock lock = new ReentrantLock();
    public void get() {
        lock.lock();
        lock.lock(); // lock与unlock成对出现
        try {
            System.out.println(Thread.currentThread().getName() + " get");
            set();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }
    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " set");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}