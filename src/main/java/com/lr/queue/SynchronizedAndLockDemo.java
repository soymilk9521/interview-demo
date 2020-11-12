package com.lr.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-12 8:37
 * ReentrantLock 精确唤醒
 */
public class SynchronizedAndLockDemo {
    public static void main(String[] args) {
       ShareResource resource = new ShareResource();
       new Thread(()->{
            resource.print5();
       }, "t1").start();

        new Thread(()->{
            resource.print10();
        }, "t2").start();

        new Thread(()->{
            resource.print15();
        }, "t3").start();
    }
}

class ShareResource {
    private int state = 1;
    Lock lock = new ReentrantLock();
    Condition a1 = lock.newCondition();
    Condition b1 = lock.newCondition();
    Condition c1 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            while (state != 1) {
                a1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t print " + i);
            }
            state = 2;
            b1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try {
            while (state != 2) {
                b1.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t print " + i);
            }
            state = 3;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            while (state != 3) {
                c1.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t print " + i);
            }
            state = 1;
            a1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}