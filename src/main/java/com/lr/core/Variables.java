package com.lr.core;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-22 8:01
 *
 */
public class Variables {
    static int s; // 类变量
    int i; // 实例变量
    int j; // 实例变量
    {
        int i = 1; // 局部变量，i
        i++;  // 就近原则，非静态代码块中局部变量i
        j++;  // 就近原则，实例变量j
        s++;  // 就近原则，类变量s
    }
    public void test(int j) {
        j++; // 局部变量，j
        j++;  // 就近原则，实例变量j
        s++;  // 就近原则，类变量s
    }
    public static void main(String[] args) {
        Variables v1 = new Variables(); // 局部变量，v1
        Variables v2 = new Variables(); // 局部变量，v2
        v1.test(10);
        v1.test(20);
        v2.test(30);
        System.out.println("v1.i=" + v1.i + ", v1.j=" + v1.j +", v1.s=" + v1.s);
        System.out.println("v2.i=" + v2.i + ", v2.j=" + v2.j +", v2.s=" + v2.s);
    }
}
