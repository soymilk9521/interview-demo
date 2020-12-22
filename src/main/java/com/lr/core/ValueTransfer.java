package com.lr.core;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-21 8:17
 */
public class ValueTransfer {

    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer num = 200;
        int[] arr = {1, 2, 3, 4, 5};
        MyData my = new MyData("karl");

        changeValue(i, str, num, arr, my);
        System.out.println("i=" + i);
        System.out.println("str=" + str);
        System.out.println("num=" + num);
        System.out.println("arr=" + Arrays.toString(arr));
        System.out.println(my);
    }

    private static void changeValue(int i, String str, Integer num, int[] arr, MyData my) {
        i = i + 1;
        str += "world";
        num = num + 1;
        arr[0] = 2;
        my.name = "tom";
    }
}
