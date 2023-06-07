package com.lee.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author LiJing
 * @version 1.0
 * <p>
 * 测试 @Profile条件装配功能：@Profile可以修饰在类上
 */
@Profile(value = {"prod", "default"})
@Component
@ConfigurationProperties("person")
@Data
public class Boss implements Person {
    private String name;
    private Integer age;
}
