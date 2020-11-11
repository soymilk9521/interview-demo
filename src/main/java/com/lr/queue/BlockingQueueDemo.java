package com.lr.queue;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-11 7:19
 * ArrayBlockingQueue：是一个基于数组结构的阻塞队列，此队列按照FIFO对元素进行排序
 * LinkedBlockingQueue：是一个基于链表结构的阻塞队列，此队列按照FIFO对元素进行排序，吞吐量大于ArrayBlockingQueue
 * SynchronousQueue：一个不存储元素的阻塞队列，每个插入操作必须等另一个线程移除操作，否则操作一直处于阻塞状态，吞吐量通常高
 *
 * 1. 队列
 *
 * 2. 阻塞队列
 *      2.1 阻塞队列有没有好处
 *      2.2 不得不阻塞的时候如何管理
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
//        溢出异常，空元素异常
//        System.out.println(queue.add("a"));
//        System.out.println(queue.add("b"));
//        System.out.println(queue.add("c"));
//        System.out.println(queue.add("d")); // java.lang.IllegalStateException: Queue full
//        System.out.println(queue.element()); // a, if queue is empty than throw java.util.NoSuchElementException
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove()); // java.util.NoSuchElementException

//        溢出false，空元素null
//        System.out.println(queue.offer("a"));
//        System.out.println(queue.offer("b"));
//        System.out.println(queue.offer("c"));
//        System.out.println(queue.offer("a")); // false
//        System.out.println(queue.peek()); // a, if queue is empty than return null
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll()); // null

//         溢出阻塞, 空值阻塞
//        queue.put("a");
//        queue.put("b");
//        queue.put("c");
//        System.out.println("=============");
//        queue.put("d"); // 阻塞
//        System.out.println(queue.take());
//        System.out.println(queue.take());
//        System.out.println(queue.take());
//        System.out.println(queue.take()); // 阻塞

        System.out.println(queue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(queue.offer("b", 2, TimeUnit.SECONDS));
        System.out.println(queue.offer("c", 2, TimeUnit.SECONDS));
        System.out.println("=====================");
//        System.out.println(queue.offer("d", 2, TimeUnit.SECONDS));  // 阻塞两秒返回false
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
        System.out.println(queue.poll(2, TimeUnit.SECONDS)); // 阻塞两秒返回null
    }
}
