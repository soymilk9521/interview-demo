package com.lr.gc;

import org.omg.SendingContext.RunTime;

import java.lang.ref.SoftReference;
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
//        System.out.println("***********HelloGC");
//        try {
//            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);} catch (InterruptedException e) { e.printStackTrace();}
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("TOTAL_MEMORY(Xms)=" + totalMemory + "(字节)、" + (totalMemory/(double)1024/1024) + "MB");
        System.out.println("MAX_MEMORY(Xmx)=" + maxMemory + "(字节)、" + (maxMemory/(double)1024/1024) + "MB");
        // byte[] bytes = new byte[50*1024*1024];
        SoftReference softReference = null;
    }
}
