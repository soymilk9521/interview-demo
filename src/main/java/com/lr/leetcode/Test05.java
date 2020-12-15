package com.lr.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-08 8:25
 */
public class Test05 {
    public static void main(String[] args) {
        List<String> list1 = null;

    }

    public static boolean oneEditAway(String first, String second) {
        if (first.equals(second)) return true;
        if (first.length() - second.length() > 1 || first.length() - second.length() < -1) return false;
        List<String> list = new ArrayList<>();

        return false;
    }
}
