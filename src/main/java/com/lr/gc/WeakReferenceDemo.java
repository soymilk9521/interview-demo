package com.lr.gc;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-19 21:44
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();
        WeakReference<Object> softReference = new WeakReference<>(obj1);
        System.out.println(obj1);
        System.out.println(softReference.get());

        obj1 = null;
        System.gc();

        System.out.println(obj1); // null 被回收
        System.out.println(softReference.get()); // null 被回收
    }
}
