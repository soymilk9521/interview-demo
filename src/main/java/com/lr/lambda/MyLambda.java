package com.lr.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    public static void helloNum(int num) {
        System.out.println("这是一个参数num=" + num + "，没有返回值的静态实现方法");
    }
    public static void helloAb(int a, int b) {
        System.out.println("这是多个参数a=" + a + ", b=" + b + "，没有返回值的静态实现方法");
    }

    public static int helloResult(int a, int b) {
        System.out.println("这是多个参数a=" + a + ", b=" + b + "，有返回值(a+b=" + (a+b) + ")的静态实现方法");
        return a + b;
    }
    public void world() {
        System.out.println("这是一个没有参数，也没有返回值的普通的非静态的实现方法");
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

        StaticMethodInterfaceWithSingleParam lambda6 = MyLambda::helloNum;
        lambda6.test(100);

        StaticMethodInterfaceWithMultipleParam lambda7 = MyLambda::helloAb;
        lambda7.test(10, 20);

        StaticMethodInterfaceReturnWithMultipleParam lambda8 = MyLambda::helloResult;
        System.out.println("a+b=" + lambda8.test(10, 20));

        NoneStaticMethodInterfaceNoneReturnWithNoneParam lambda9 = new MyLambda()::world;
        lambda9.test();

        SpecialObjectInterface lambda10 = Person::setName;
        Person p = new Person();
        System.out.println(p.getName());
        lambda10.test(p, "karl");
        System.out.println(p.getName());

        SpecialObjectInterface lambda11 = Person::show;
        lambda11.test(p, "hello world");

        ConstructorInterface lambda12 = Person::new;
        Person p2 = lambda12.test("tom");
        System.out.println(p2.getName());
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

@FunctionalInterface
interface StaticMethodInterfaceWithMultipleParam {
    void test(int a, int b);
}

@FunctionalInterface
interface StaticMethodInterfaceReturnWithMultipleParam {
    int test(int a, int b);
}

@FunctionalInterface
interface NoneStaticMethodInterfaceNoneReturnWithNoneParam {
    void test();
}

@FunctionalInterface
interface SpecialObjectInterface {
    void test(Person person, String name);
}

@FunctionalInterface
interface ConstructorInterface {
    Person test(String name);
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    private String name;
    private Integer age;
    Person(String name) {
        this.name = name;
        System.out.println("我的名字：" + name);
    }

    public void show(String boom){
        System.out.println("show() is running" + boom);
    }

    public void say(String hello) {
        System.out.println(this.name + " is saying " + hello);
    }

    public  void calc(int a, int b){
        System.out.println("a+b=" + (a + b));
    }
}