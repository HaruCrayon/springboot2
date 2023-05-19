package com.lee.boot.controller;

import com.lee.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiJing
 * @version 1.0
 */

@RestController
public class HelloController {
    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person person() {
        String userName = person.getUserName();
        System.out.println("userName=" + userName);
        return person;
    }
}
