package com.lr.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-11 20:56
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                queue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put 2");
                queue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put 3");
                queue.put("3");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(()->{
            try {
                try {
                   TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) { e.printStackTrace();}
                System.out.println(Thread.currentThread().getName() + "\t take 1");
                queue.take();
                try {
                    TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) { e.printStackTrace();}
                System.out.println(Thread.currentThread().getName() + "\t take 2");
                queue.take();
                try {
                    TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) { e.printStackTrace();}
                System.out.println(Thread.currentThread().getName() + "\t take 3");
                queue.take();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
