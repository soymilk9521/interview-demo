package com.lr.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-06 7:56
 *
 * 什么是CAS ===> Compare And Swap
 *   比较并交换
 *
 */
public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t atomicInteger is " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t atomicInteger is " + atomicInteger.get());
        atomicInteger.getAndIncrement();
    }
}
