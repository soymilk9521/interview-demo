package com.lr.error;

import sun.misc.VM;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-21 9:39
 */
public class GCDirectBufferMemoryDemo {
    public static void main(String[] args) {
        // -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
        System.out.println("直接内存大小：" + VM.maxDirectMemory()/ (double)1024/ 1024 + "MB");
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("TOTAL_MEMORY(Xms)=" + totalMemory + "(字节)、" + (totalMemory/(double)1024/1024) + "MB");
        System.out.println("MAX_MEMORY(Xmx)=" + maxMemory + "(字节)、" + (maxMemory/(double)1024/1024) + "MB");

        try {
            TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) { e.printStackTrace();}
        // NIO, 在直接内存中创建对象
        ByteBuffer.allocateDirect(6* 1024* 1024); // java.lang.OutOfMemoryError: Direct buffer memory
    }
}
