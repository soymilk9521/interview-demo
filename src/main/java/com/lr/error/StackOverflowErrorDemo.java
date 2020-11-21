package com.lr.error;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-20 8:32
 */
public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError(); // Exception in thread "main" java.lang.StackOverflowError
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }
}
