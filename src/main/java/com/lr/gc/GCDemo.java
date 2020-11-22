package com.lr.gc;

import java.util.Random;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-21 22:34
 *
 * 1. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC (DefNew + Tenured)
 *
 * 2. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC (ParNew + Tenured)
 *
 * 3. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC (PSYounGen + ParOldGen)
 *
 * 4. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC (PSYounGen + ParOldGen)
 *
 * 5. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC (ParNew + CMS)
 *
 * 6. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC
 *
 * 7. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialOldGC (废弃)
 */
public class GCDemo {
    public static void main(String[] args) {
        System.out.println("***** GCDemo hello");
        try {
            String str = "helloGC";
            while (true) {
                str += str + new Random().nextInt(7777777) + new Random().nextInt(88888888);
                str.intern();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
