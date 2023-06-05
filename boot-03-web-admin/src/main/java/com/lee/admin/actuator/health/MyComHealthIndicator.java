package com.lee.admin.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiJing
 * @version 1.0
 * <p>
 * 定制一个组件的 Health 信息
 */
@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {

    //真实的检查方法
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //mongodb 获取连接进行测试
        Map<String, Object> map = new HashMap<>();
        // 检查完成
        if (1 == 1) {
//            builder.up(); //健康
            builder.status(Status.UP);
            map.put("count", 1);
            map.put("ms", 100);
        } else {
//            builder.down();
            builder.status(Status.OUT_OF_SERVICE);
            map.put("err", "连接超时");
            map.put("ms", 3000);
        }

        builder.withDetail("code", 100)
                .withDetails(map);
    }

}
