package com.lr.error;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-21 10:41
 *
 * 1. docker环境创建：
 * systemctl start docker  启动docker服务
 * docker run -it java:8 bash 启动并运行java8容器
 *  docker cp /root/temp/GCCannotCreateNativeThreadDemo.java 315cb9da6b92:/ 将java类拷贝到docker容器
 * 2. 运行java命令：
 * javac -d . GCCannotCreateNativeThreadDemo.java
 * java com.lr.error.GCCannotCreateNativeThreadDemo（含报名执行）
 * 抛出异常java.lang.OutOfMemoryError: unable to create new native thread错误
 *
 * 3. 杀死java进程
 * ps -ef|grep java 查询java进程
 * kill -9 7878    通过进程id杀死java进程
 */
public class GCCannotCreateNativeThreadDemo {
    public static void main(String[] args) {
        // docker 环境执行
        for (int i = 0;  ; i++) {
            System.out.println("**************** " + i);
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);} catch (InterruptedException e) { e.printStackTrace();}
            }, String.valueOf(i)).start(); // java.lang.OutOfMemoryError: unable to create new native thread（创建了29015个线程）
        }
    }
}
