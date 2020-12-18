package com.lr.core;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-18 8:06
 * 1. 类初始化（<clinit>()方法）：子类初始化前先初始化父类（顺序执行） (5) (1)
 *    1.1. j = method();   // (10)
 *    1.2. static静态代码块 // (6)
 * 2. 实例初始化（<init>()方法）：首先super调用父类构造函数 （super最前，构造函数最后，其他顺序执行）
 *    2.1. super() (最前)  // (9) (3) (2)
 *    2.2. i = test();    // (9)
 *    2.3. 非静态代码块    // (8)
 *    2.4. 构造函数（最后） // (7)
 */
public class Son extends Father {
    private int i = test();
    private static int j = method();

    static {
        System.out.println("(6)");
    }
    public Son() {
        super(); // 写或不写它都存在
        System.out.println("(7)");
    }

    {
        System.out.println("(8)");
    }

    public int test() {
        System.out.println("(9)");
        return 1;
    }

    public static int method() {
        System.out.println("(10)");
        return 1;
    }

    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println("==========");
        Son s2 = new Son();
    }
}
