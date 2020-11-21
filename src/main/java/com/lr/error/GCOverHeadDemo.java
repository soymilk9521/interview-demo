package com.lr.error;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-21 9:25
 */
public class GCOverHeadDemo {
    public static void main(String[] args) {
        Integer i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                // intern()如果常量池中存在当前字符串, 就会直接返回当前字符串. 如果常量池中没有此字符串, 会将此字符串放入常量池中后, 再返回
                list.add(String.valueOf(++i).intern()); // java.lang.OutOfMemoryError: GC overhead limit exceeded
            }
        } catch (Exception e) {
            System.out.println(" *************** " + i);
            e.printStackTrace();
        } finally {
        }
    }
}
