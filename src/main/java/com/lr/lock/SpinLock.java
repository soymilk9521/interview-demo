package com.lr.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-09 8:53
 */
public class SpinLock {
    public static void main(String[] args) {
        MyLock lock = new MyLock();
        new Thread(()->{
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) { e.printStackTrace();}
            lock.unLock();
        }, "t1").start();
        try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
        new Thread(()->{
            lock.lock();
            lock.unLock();
        }, "t2").start();
        Integer a = 1000;
        Integer b = 1000;
        System.out.println( a.compareTo(b) == 0);
    }

}

class MyLock {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void lock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t come in O(∩_∩)O");
        while (!atomicReference.compareAndSet(null, thread)){

        }
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t invoke unLock()");
        while (!atomicReference.compareAndSet(thread, null)){

        }
    }
}