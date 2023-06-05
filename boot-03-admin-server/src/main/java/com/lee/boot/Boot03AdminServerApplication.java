package com.lee.boot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class Boot03AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot03AdminServerApplication.class, args);
    }

}
