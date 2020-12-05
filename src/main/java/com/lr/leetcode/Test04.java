package com.lr.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-05 15:24
 */
public class Test04 {
    public static void main(String[] args) {
        System.out.println(canPermutePalindrome(""));
        System.out.println(canPermutePalindrome("tactcoa"));
        System.out.println(canPermutePalindrome("atcocta"));
        System.out.println(canPermutePalindrome("tacocat"));
        System.out.println(canPermutePalindrome("aab"));
        System.out.println(canPermutePalindrome("abc"));
    }

    public static boolean canPermutePalindrome(String s) {
        int[] intArr = new int[128];
        for (char c : s.toCharArray()) {
            intArr[c] ++;
        }
        int count = 0;
        for (int i : intArr) {
            if(i % 2 != 0) {
                count++;
            }
            if(count > 1) {
                return false;
            }
        }
        return true;
    }
}
