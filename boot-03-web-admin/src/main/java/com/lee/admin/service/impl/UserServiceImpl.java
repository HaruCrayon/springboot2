package com.lee.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.admin.bean.User;
import com.lee.admin.mapper.UserMapper;
import com.lee.admin.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author LiJing
 * @version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
