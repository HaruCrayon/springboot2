package com.lee.boot.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author LiJing
 * @version 1.0
 */

//@Component
@ConfigurationProperties(prefix = "mycar")
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String brand;
    private Integer price;
}
