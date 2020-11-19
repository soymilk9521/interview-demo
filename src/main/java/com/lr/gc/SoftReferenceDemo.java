package com.lr.gc;

import java.lang.ref.SoftReference;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-19 21:27
 * 软引用事例
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
        // memoryEnough();
        memoryNotEnough();
    }

    public static void memoryEnough() {
        Object obj1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj1);
        System.out.println(obj1);
        System.out.println(softReference.get());
        obj1 = null;
        System.gc();
        System.out.println(obj1); // null 被回收
        System.out.println(softReference.get()); // 不会被回收
    }

    public static void memoryNotEnough() {
        // jvm参数设置 -Xmx10m -Xms10m -XX:+PrintGCDetails
        Object obj1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj1);
        System.out.println(obj1);
        System.out.println(softReference.get());
        obj1 = null;
        try {
            byte[] butes = new byte[30*1024*1024]; // 创建一个30M大对象
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(obj1); // null 被回收
            System.out.println(softReference.get()); // null 内存不足，被回收
        }
    }


}
