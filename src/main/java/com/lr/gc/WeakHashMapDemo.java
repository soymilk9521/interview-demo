package com.lr.gc;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-19 22:02
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        myHashMap();
        System.out.println("=================");
        myWeakHashMap();
    }



    private static void myHashMap() {
        Map<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);
        System.gc();

        System.out.println(map);
    }

    private static void myWeakHashMap() {

        Map<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "WeakHashMap";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);
        System.gc();

        System.out.println(map); // 被回收
    }
}
