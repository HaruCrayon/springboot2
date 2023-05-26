package com.lee.boot.controller;

import com.lee.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author LiJing
 * @version 1.0
 */

@Controller
public class ResponseTestController {

    //利用返回值处理器里面的消息转换器进行处理
    @ResponseBody  //RequestResponseBodyMethodProcessor ---> MessageConverter
    @GetMapping(value = "/test/person")
    public Person getPerson() {
        Person person = new Person();
        person.setAge(28);
        person.setBirth(new Date());
        person.setUserName("zhang 张三");
        return person;
    }
}
