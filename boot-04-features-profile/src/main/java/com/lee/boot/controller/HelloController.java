package com.lee.boot.controller;

import com.lee.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiJing
 * @version 1.0
 */
@RestController
public class HelloController {
    @Value("${person.name:李四}")
    private String name;

    @Value("${JAVA_HOME}")
    private String msg;

    @Value("${os.name}")
    private String osName;

    @Autowired
    private Person person;

    @GetMapping("/")
    public Person hello() {

//        return person.getClass().toString();
        return person;
    }

    @GetMapping("/msg")
    public String getMsg() {

        return msg + "==>" + osName;
    }
}
