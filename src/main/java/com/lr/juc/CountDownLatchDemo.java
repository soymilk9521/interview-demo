package com.lr.juc;

import com.lr.myenum.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-10 8:29
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDown = new CountDownLatch(6);
        for (int i = 1; i < 7; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "国, 被灭");
                countDown.countDown();
            }, CountryEnum.getCountry(i).getCountryName()).start();
        }
        countDown.await();
        System.out.println(Thread.currentThread().getName() + " 大秦帝国，统一华夏");
    }
}
