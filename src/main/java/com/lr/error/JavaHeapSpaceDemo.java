package com.lr.error;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-20 8:38
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        byte[] bytes = new byte[30*1024*1024]; // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }
}
