package com.lr.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-09 21:10
 * 写操作独占，不可分割，读操作共享，可以分割
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache cache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int tempi = i;
            new Thread(()->{
                cache.put(tempi + "",  tempi);
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tempi = i;
            new Thread(()->{
                cache.get(tempi + "");
            }, String.valueOf(i)).start();
        }
    }
}

class MyCache {
    private volatile Map cache = new HashMap();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
        try {TimeUnit.MILLISECONDS.sleep(300);} catch (InterruptedException e) { e.printStackTrace();}
        cache.put(key, value);
        System.out.println(Thread.currentThread().getName() + "\t 写入完成...");
        lock.writeLock().unlock();
    }

    public void get(String key) {
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + "\t 正在读取：" + key);
        try {TimeUnit.MILLISECONDS.sleep(300);} catch (InterruptedException e) { e.printStackTrace();}
        Object result = cache.get(key);
        System.out.println(Thread.currentThread().getName() + "\t 读取完成..." + result);
        lock.readLock().unlock();
    }
}