package com.lr.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-02 8:57
 */
public class Test02 {
    public static void main(String[] args) {
        System.out.println(CheckPermutation("", ""));
        System.out.println(CheckPermutation("abc", "cba"));
        int[] arr = new int[128];
        System.out.println(arr[9]);
    }

    public static boolean CheckRevertPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || (s1.length() != s2.length())){
            return false;
        }
        char[] temp = new char[s1.length()];
        int len = s1.length();
        for (int i = len - 1; i >= 0 ; i--) {
            temp[len - 1 - i] = s1.charAt(i);
        }
        System.out.println(new String(temp));
        return s2.equals(new String(temp));
    }

    public static boolean CheckPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || (s1.length() != s2.length())){
            return false;
        }
//        char[] arr1 = new char[s1.length()];
//        for (int i = 0; i < s1.length() ; i++) {
//            arr1[i] = s1.charAt(i);
//        }
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
//        char[] arr2 = new char[s2.length()];
//        for (int i = 0; i < s2.length() ; i++) {
//            arr2[i] = s2.charAt(i);
//        }
        char[] arr2 = s1.toCharArray();
        Arrays.sort(arr2);
        return new String(arr2).equals(new String(arr1));
    }
}
