package com.lee.boot.config;

import com.lee.boot.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author LiJing
 * @version 1.0
 * <p>
 * 测试 @Profile条件装配功能：@Profile可以修饰在方法上
 */
@Configuration
public class MyConfig {

    @Profile("prod")
    @Bean
    public Color red() {
        return new Color();
    }

    @Profile("test")
    @Bean
    public Color green() {
        return new Color();
    }
}
