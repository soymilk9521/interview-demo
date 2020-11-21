package com.lr.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-20 7:57
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>(); // 引用队列
        WeakReference<Object> weakReference = new WeakReference<>(o1, queue);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(queue.poll()); // null

        o1 = null;
        System.gc();
        Thread.sleep(500);
        System.out.println("===============");

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(queue.poll()); // 弱引用被回收后，添加到引用队列中

    }
}
