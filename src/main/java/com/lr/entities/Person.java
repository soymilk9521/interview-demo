package com.lr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-08 16:24
 */
@Data
@AllArgsConstructor
public class Person {
    private Integer age;
    private String name;
    public Person(String name){
        this.name = name;
    }

}
