package com.lee.admin.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author LiJing
 * @version 1.0
 * <p>
 * 定制 info 信息
 */
@Component
public class AppInfoInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {

        builder.withDetail("msg", "你好")
                .withDetail("hello", "lee")
                .withDetails(Collections.singletonMap("world", "666600"));
    }
}
