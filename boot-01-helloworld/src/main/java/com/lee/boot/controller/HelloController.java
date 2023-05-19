package com.lee.boot.controller;

import com.lee.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiJing
 * @version 1.0
 */

@Slf4j
@RestController
public class HelloController {
    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }

    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name) {
        log.info("请求进来了....");
        return "Hello, Spring Boot 2!" + " 你好：" + name;
    }
}
