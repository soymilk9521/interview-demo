package com.lr.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-20 8:10
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>(); // 引用队列
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, queue);
        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll()); // null

        o1 = null;
        System.gc();
        Thread.sleep(500);
        System.out.println("===============");

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll()); // 虚引用被回收后，添加到引用队列中
    }
}
