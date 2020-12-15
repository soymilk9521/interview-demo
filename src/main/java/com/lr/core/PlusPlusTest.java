package com.lr.core;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-14 7:51
 *   比照字节码：
 *        0: iconst_1
 *        1: istore_1
 *        2: iload_1
 *        3: iinc          1, 1
 *        6: istore_1
 *        7: iload_1
 *        8: iinc          1, 1
 *       11: istore_2
 *       12: iload_1
 *       13: iinc          1, 1
 *       16: iload_1
 *       17: iload_1
 *       18: iinc          1, 1
 *       21: imul
 *       22: iadd
 *       23: istore_3
 */
public class PlusPlusTest {
    public static void main(String[] args) {
        int i = 1;
        i = ++i;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i=" + i);  // 5
        System.out.println("j=" + j);  // 2
        System.out.println("k=" + k);  // 19
    }

}
