package com.lee.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author LiJing
 * @version 1.0
 */

@Controller
public class ViewTestController {

    @GetMapping("/lee")
    public String atguigu(Model model) {
        //model中的数据会被放在请求域中 request.setAttribute("x",xxx)
        model.addAttribute("msg", "你好 lee");
        model.addAttribute("link", "http://www.baidu.com");

        return "success";
    }
}
