package com.lr.gc;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-18 8:19
 */
public class HelloGC {
    public static void main(String[] args) {
        // jps -l 查看Java运行中进程
        // jinfo -flag PrintGCDetails java进程ID  查看JVM参数配置
        System.out.println("***********HelloGC");
        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);} catch (InterruptedException e) { e.printStackTrace();}
    }
}
