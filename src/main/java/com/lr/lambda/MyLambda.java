package com.lr.lambda;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-01 8:39
 */
public class MyLambda {
    public static void hello() {
        System.out.println("这是一个没有参数，也没有返回值的静态实现方法");
    }
    public static void hello(int num) {
        System.out.println("这是一个参数num=" + num + "，没有返回值的静态实现方法");
    }
    public static void main(String[] args) {
        NoneReturnInterfaceWithNoneParam lambda1 = () -> {
            System.out.println("这是一个没有参数，也没有返回值的普通实现方法");
        };
        lambda1.test();
//        NoneReturnInterfaceWithSingleParam lambda2 = (num) -> {
//            System.out.println("这是一个有参数 num=" + num + "，没有返回值的抽象方法");
//        };
        NoneReturnInterfaceWithSingleParam lambda2 = num -> System.out.println("这是一个有参数 num=" + num + "，没有返回值的普通实现方法");
        lambda2.test(100);

//        NoneReturnInterfaceWithMultipleParam lambda3 = (a, b) -> {
//            System.out.println("这是一个有多个参数 a=" + a + ", b=" + b +"，没有返回值的抽象方法");
//        };
        NoneReturnInterfaceWithMultipleParam lambda3 = (a, b) -> System.out.println("这是一个有多个参数 a=" + a + ", b=" + b +"，没有返回值的抽象方法");
        lambda3.test(10, 20);

        WithReturnInterfaceWithMultipleParam lambda4 = (a, b) -> "a+b=" + (a + b);
        System.out.println(lambda4.test(10, 20));

        StaticMethodInterfaceWithNoneParam lambda5 = MyLambda::hello;
        lambda5.test();

        StaticMethodInterfaceWithSingleParam lambda6 = MyLambda::hello;
        lambda6.test(100);
    }
}

@FunctionalInterface
interface NoneReturnInterfaceWithNoneParam {
    void test();
}

@FunctionalInterface
interface NoneReturnInterfaceWithSingleParam {
    void test(int num);
}

@FunctionalInterface
interface NoneReturnInterfaceWithMultipleParam {
    void test(int a, int b);
}

@FunctionalInterface
interface WithReturnInterfaceWithMultipleParam {
    String test(int a, int b);
}

@FunctionalInterface
interface StaticMethodInterfaceWithNoneParam {
    void test();
}

@FunctionalInterface
interface StaticMethodInterfaceWithSingleParam {
    void test(int num);
}

