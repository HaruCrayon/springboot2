package com.lee.admin.config;

import com.lee.admin.servlet.MyFilter;
import com.lee.admin.servlet.MyServlet;
import com.lee.admin.servlet.MyServletContextListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author LiJing
 * @version 1.0
 * <p>
 * Web原生组件注入（Servlet、Filter、Listener）
 * 方式一：使用原生注解（Servlet API）@WebServlet、@WebFilter、@WebListener 配合 @ServletComponentScan
 * 方式二：Spring方式注入（使用 RegistrationBean）
 * <p>
 * 系统中有两个Servlet
 * 1、MyServlet --> /my
 * 2、DispatcherServlet --> /
 */
@Configuration
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean<MyServlet> myServlet() {
        MyServlet myServlet = new MyServlet();

        return new ServletRegistrationBean<MyServlet>(myServlet, "/my", "/my02");
    }

    @Bean
    public FilterRegistrationBean<MyFilter> myFilter() {
        MyFilter myFilter = new MyFilter();

//        return new FilterRegistrationBean(myFilter, myServlet());
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<MyFilter>(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my", "/css/*"));

        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<MyServletContextListener> myListener() {
        MyServletContextListener myServletContextListener = new MyServletContextListener();

        return new ServletListenerRegistrationBean<MyServletContextListener>(myServletContextListener);
    }

}
