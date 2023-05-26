package com.lee.boot.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author LiJing
 * @version 1.0
 */

@Data
public class Person {
    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;
}
