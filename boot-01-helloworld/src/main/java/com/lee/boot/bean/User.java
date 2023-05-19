package com.lee.boot.bean;

import lombok.*;

/**
 * @author LiJing
 * @version 1.0
 */

@Data
@ToString
@EqualsAndHashCode
//@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
    private Pet pet;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
