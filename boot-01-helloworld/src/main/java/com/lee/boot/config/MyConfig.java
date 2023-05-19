package com.lee.boot.config;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.lee.boot.bean.Car;
import com.lee.boot.bean.Pet;
import com.lee.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author LiJing
 * @version 1.0
 * <p>
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：
 * Full(proxyBeanMethods = true)【保证每个@Bean方法被调用多少次返回的组件都是之前注册在容器中的单实例对象】
 * Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 * 组件依赖必须使用Full模式。其他默认是Lite模式
 * 4、@Import({User.class, EchoEncoder.class})
 * 在容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 * 5、@Conditional 条件装配
 * 6、@ImportResource 原生配置文件引入
 * 7、@EnableConfigurationProperties(Car.class)
 * (1)开启Car配置绑定功能 (2)把Car这个组件自动注册到容器中
 */

@Configuration(proxyBeanMethods = true) //注解 @Configuration：告诉SpringBoot这是一个配置类 == 配置文件
@Import({User.class, EchoEncoder.class})
//@ConditionalOnBean(name = "pet02")
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    //@ConditionalOnBean(name = "pet01")
    //@ConditionalOnMissingBean(name = "pet01")
    @Bean  //给容器中添加组件。以方法名作为组件的id，返回类型就是组件类型，返回的值就是组件在容器中的实例
    public User user01() {
        User user = new User("张三", 20);
        //User组件依赖了Pet组件
        user.setPet(pet01());
        return user;
    }

    @Bean
    public Pet pet01() {
        return new Pet("tomCat");
    }
}
