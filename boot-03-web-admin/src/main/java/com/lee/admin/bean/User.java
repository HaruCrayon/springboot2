package com.lee.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author LiJing
 * @version 1.0
 */
@TableName("user")
@Data
public class User {
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    //数据库表user的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
