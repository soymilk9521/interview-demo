package com.lr.gc;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-19 21:16
 * 强引用事例
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = obj1;
        System.out.println(obj1);
        System.out.println(obj2);

        obj1 = null;
        System.gc();

        System.out.println(obj1);  // obj1被回收
        System.out.println(obj2);  // obj2不会被回收
    }
}
