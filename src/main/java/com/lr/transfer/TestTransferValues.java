package com.lr.transfer;

import com.lr.entities.Person;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-08 16:32
 */
public class TestTransferValues {
    public void changeValue1(int age) {
        age = 30;
    }
    public void changeValue2(Person p){
        p.setName("xxx");
    }
    public void changeValue3(String str){
        str = "xxx";
    }

    public static void main(String[] args) {
        TestTransferValues test = new TestTransferValues();
        int age = 20;
        test.changeValue1(age);
        System.out.println("age ---> " + age); // 20
        Person p = new Person("abc");
        test.changeValue2(p);
        System.out.println("name ---> " + p.getName()); // xxx
        String str = "abc";
        String str2 = "xxx";
        test.changeValue3(str);
        System.out.println("str ---> " + str); // abc

        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));
    }
}
