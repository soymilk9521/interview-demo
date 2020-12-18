package com.lr.core;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-18 8:02
 * 1. 类初始化（<clinit>()方法）
 *    1.1 j = method(); // （5）
 *    1.2 staic代码块    // （1）
 * 2. 实例初始化（<init>()方法）
 *    2.1. super() (最前)
 *    2.2. i = test();  // (9)
 *    2.3. 非静态代码块  // (3)
 *    2.4. 构造函数（最后） // (2)
 * 3. 方法重写Override
 *   非静态方法前面有一个默认的this对象
 *   this在构造函数（或<init>）表示的是正在创建的对象，因为这里面正在创建的对象是Son对象，
 *   所以test()执行子类重写代码（面向对象多态）
 *   这里i = test();执行的是子类的test()方法
 *
 *
 */
public class Father {
    private int i = test();
    private static int j = method();

    static {
        System.out.println("(1)");
    }
    public Father() {
        System.out.println("(2)");
    }

    {
        System.out.println("(3)");
    }

    public int test() {
        System.out.println("(4)");
        return 1;
    }

    public static int method() {
        System.out.println("(5)");
        return 1;
    }
}
