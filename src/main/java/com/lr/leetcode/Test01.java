package com.lr.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-01 7:49
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println(isUniqueHashSet(""));
        System.out.println(isUniqueHashSet("abcdef"));
        System.out.println(isUniqueHashSet("leetcode"));
    }

    public static boolean isUnique(String str){
        char[] chars = null;
        Map<Character, Object> map = new HashMap<>();
        if (str != null && str.length()>0) {
            chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (map.containsKey(chars[i])){
                    return false;
                }else {
                    map.put(chars[i], new Object());
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isUniqueHashSet(String str){
        HashSet<Character> characterSet = new HashSet<>();
        for (int i = 0; i < str.length() ; i++) {
            characterSet.add(str.charAt(i));
        }
        return characterSet.size() == str.length();
    }

    public static boolean isUniqueIndexOf(String str){
        if (str == null){
            return false;
        }
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) != str.lastIndexOf(str.charAt(i))) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
