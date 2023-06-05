package com.lee.admin.controller;

import com.lee.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author LiJing
 * @version 1.0
 */
@Slf4j
@Controller
public class IndexController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //登录页
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    //登录
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUserName()) && "123".equals(user.getPassword())) {
            session.setAttribute("loginUser", user);
            //登录成功，重定向到main.html  (重定向防止表单重复提交)
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
    }

    //主页
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        log.info("当前目标方法是 {}", "mainPage");
        //登录检查。拦截器，过滤器
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null) {
//            return "main";
//        } else {
//            model.addAttribute("msg", "请重新登录");
//            return "login";
//        }
        return "main";
    }

    //测试操作数据库-查询
    @ResponseBody
    @GetMapping("/sql")
    public String query() {
        Integer count = jdbcTemplate.queryForObject("select count(*) from t_emp", Integer.class);

        return count.toString();
    }

    @GetMapping("/db")
    public String toDB() {
        return "db";
    }
}
