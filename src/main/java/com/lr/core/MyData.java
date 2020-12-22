package com.lr.core;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-12-21 8:20
 */
public class MyData {
    public String name;

    public MyData(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "name='" + name + '\'' +
                '}';
    }
}
