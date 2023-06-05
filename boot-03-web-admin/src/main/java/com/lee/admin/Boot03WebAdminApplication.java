package com.lee.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.lee.admin.mapper")
//@ServletComponentScan(basePackages = "com.lee.admin")
@ServletComponentScan
@SpringBootApplication
public class Boot03WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot03WebAdminApplication.class, args);
    }

}
