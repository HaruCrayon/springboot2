package com.lee.boot;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.lee.boot.bean.Pet;
import com.lee.boot.bean.User;
import com.lee.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author LiJing
 * @version 1.0
 */

//主程序类
//注解 @SpringBootApplication: 表示这是一个SpringBoot应用
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        //1、返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MyApplication.class, args);

        //2、查看容器里面的全部组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        /*

        //3、从容器中获取组件
        User user1 = run.getBean("user01", User.class);
        User user2 = run.getBean("user01", User.class);
        System.out.println("user1 == user2：" + (user1 == user2));

        //4、代理对象
        MyConfig myConfigBean = run.getBean(MyConfig.class);
        System.out.println(myConfigBean);
        //@Configuration(proxyBeanMethods = true) --> com.lee.boot.config.MyConfig$$EnhancerBySpringCGLIB$$a08c3150@d02f8d
        //@Configuration(proxyBeanMethods = false) --> com.lee.boot.config.MyConfig@30feffc

        //如果@Configuration(proxyBeanMethods = true) 代理对象调用方法，SpringBoot总会检查这个组件是否在容器中有
        //保持组件单实例
        User user3 = myConfigBean.user01();
        User user4 = myConfigBean.user01();
        System.out.println("user3 == user4：" + (user3 == user4));

        //5、组件依赖
        User user01 = run.getBean("user01", User.class);
        Pet pet01 = run.getBean("pet01", Pet.class);
        System.out.println("用户的宠物：" + (user01.getPet() == pet01));

        //6、测试 @Import({User.class, EchoEncoder.class}) 导入的组件
        System.out.println("============");
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
            //使用@Import导入的组件：组件名字是全类名 com.lee.boot.bean.User
            //使用@Bean注册的组件：以方法名作为组件的id user01
        }

        String[] beanNames = run.getBeanNamesForType(EchoEncoder.class);
        for (String name : beanNames) {
            System.out.println(name);
            //ch.qos.logback.core.encoder.EchoEncoder 全类名
        }
        EchoEncoder bean = run.getBean(EchoEncoder.class);
        System.out.println(bean);

         */

        //7、条件装配
        boolean pet01 = run.containsBean("pet01");
        System.out.println("容器中pet01组件：" + pet01);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件：" + user01);

        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("haha：" + haha);
        System.out.println("hehe：" + hehe);

    }
}
