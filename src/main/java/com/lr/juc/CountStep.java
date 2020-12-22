package com.lr.juc;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-21 16:22
 * 面试题： 有n个台阶，每次只能前进1步或2步，共有多少种走法
 * 1. 递归
 * 2. 循环迭代
 */
public class CountStep {
    /**
     * 递归方法
     * n=1, f(1) = 1
     * n=2, f(2) = 2
     * n=3, f(3) = f(2) + f(1)
     * n=x, f(x) = f(x-1) + f(x-2)
     */

    public static int recursionCounter(int n) {
        if (n < 1)
            throw new IllegalArgumentException("传入参数不能小于1");
        if (n==1 || n == 2) {
            return n;
        }
        return recursionCounter(n-1 ) + recursionCounter(n-2);
    }

    /**
     * 循环迭代
     * n=1, f(1) = 1
     * n=2, f(2) = 2
     * n=3, f(3) = f(1) + f(2)
     *             two  + one
     * n=4, f(4) = f(2) + f(3)
     *             two  + one
     * n=x, f(x) = f(x-2) + f(x-1)
     *             two  + one
     */

    public static int iteratorCounter(int n) {
        if (n < 1)
        throw new IllegalArgumentException("传入参数不能小于1");
        if (n==1 || n == 2) {
            return n;
        }
        int one = 2; // 初始化走到第二级台阶走法
        int two = 1; // 初始化走到第一级台阶走法
        int sum = one + two;
        for (int i = 3; i < n; i++) {
            two = one;  // 上一步的one
            one = sum;  // 上一步的sum
            sum = one + two;
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(recursionCounter(40));
        long end = System.currentTimeMillis();
        System.out.println("递归用时：" + (end - start));
        long start2 = System.currentTimeMillis();
        System.out.println(iteratorCounter(40));
        long end2 = System.currentTimeMillis();
        System.out.println("迭代用时：" + (end2 - start2));
    }
}
