package com.lee.admin.controller;

import com.lee.admin.bean.Emp;
import com.lee.admin.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LiJing
 * @version 1.0
 */
@Controller
public class EmpController {
    @Autowired
    EmpService empService;

    @ResponseBody
    @GetMapping("/emp")
    public Emp getEmpById(@RequestParam("id") Integer id) {

        return empService.getEmpById(id);
    }
}
