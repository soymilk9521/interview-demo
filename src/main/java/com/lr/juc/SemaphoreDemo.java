package com.lr.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-10 9:26
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 获得停车位");
                    try {
                        TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) { e.printStackTrace();}
                    System.out.println(Thread.currentThread().getName() + "\t 离开停车位");


                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
