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
 * @since 2020-11-12 7:49
 * 生产者消费者应用（传统版）:初始值为零的变量，两个线程交替操作，一个加一一个减一，循环五次
 * 多线程口诀：
 * 1. 线程   操作（方法）   资源类
 * 2. 判断（if --> while） 干活  要唤醒
 * 3. 防止虚假唤醒
 */
public class ProdConsumerTraditionDemo {
    public static void main(String[] args) {
        // 资源类
        ShareData shareData = new ShareData();
        // 线程
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                // 操作
                shareData.increment();
            }
        }, "t1").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareData.decrement();
            }
        }, "t2").start();
    }
}

/**
 * 资源类高内聚低耦合，自身提供两个方法
 */
class ShareData {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment() {
        lock.lock();
        try {
            // 判断
            while (this.num != 0) {
                condition.await();
            }
            // 干活
            this.num++;
            System.out.println(Thread.currentThread().getName() + "\t ++++++ " + num);
            // 要唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try{
            while (this.num == 0) {
                condition.await();
            }
            this.num--;
            System.out.println(Thread.currentThread().getName() + "\t ------ " + num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}