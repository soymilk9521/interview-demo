package com.lr.leetcode;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-03 8:36
 */
public class Test03 {
    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith    ", 13));
        System.out.println(replaceSpaces("               ", 5));

        Integer a = 127;
        Integer b = 127;
        Integer c = new Integer(1000);
        System.out.println(c.hashCode());
        System.out.println(a == b);
        test(c);
        System.out.println(c);
    }

    public static String replaceSpaces(String S, int length) {
        S = S.substring(0, length);
        return S.replace(" ", "%20");

//        char[] c = S.toCharArray();
//        for (int i = 0; i <c.length ; i++) {
//
//        }
//
//        System.out.println(Arrays.toString(c));
    }

    public static void test(Integer integer) {
        System.out.println(integer.hashCode());
        integer = 1001;
        System.out.println(integer.hashCode());
    }
}
