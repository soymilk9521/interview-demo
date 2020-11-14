package com.lr.queue;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-13 7:41
 */
public class ProdConsumerBlockingQueueDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);
        MyResource resource = new MyResource(blockingQueue);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 生产者启动");
            try {
                resource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "生产者").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 消费者启动");
            System.out.println();
            System.out.println();
            try {
                resource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "消费者").start();

        try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) { e.printStackTrace();}
        System.out.println();
        System.out.println();
        System.out.println("5秒钟时间到，大boss叫停生产");
        resource.stop();

    }
}

class  MyResource {
    private BlockingQueue<String> blockingQueue;
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(this.blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception {
        String data = "";
        boolean result;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            result = this.blockingQueue.offer(data, 2, TimeUnit.SECONDS);
            if (result) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列 " + data + "成功");
            }else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列 " + data + "失败");

            }
            try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
        }

        System.out.println(Thread.currentThread().getName() + "\t flag= " + flag + ", 被叫停，生产停止" );
    }

    public void myConsumer() throws Exception {
        String result = "";
        while (flag) {
            result = this.blockingQueue.poll(2, TimeUnit.SECONDS);
            if (result == null || "".equals(result)) {
                // flag = false; // 无效语句
                System.out.println(Thread.currentThread().getName() + "\t flag= " + flag + ", 没有读取到队列，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 读取队列 " + result + "成功");
        }
    }

    public void stop() {
        flag = false;
    }

}
