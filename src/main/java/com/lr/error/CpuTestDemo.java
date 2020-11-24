package com.lr.error;

import java.util.Random;
import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-23 21:00
 */
public class CpuTestDemo {
    public static void main(String[] args) {
        while (true) {
            System.out.println(UUID.randomUUID().toString().substring(0, 8));
        }
    }
}
