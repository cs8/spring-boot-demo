package com.xkcoding.docker.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xkcoding.docker.entity.User;
import com.xkcoding.docker.mapper.UserMapper;
import com.xkcoding.docker.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * User Service
 * </p>
 *
 * @package: com.xkcoding.orm.mybatis.plus.service.impl
 * @description: User Service
 * @author: yangkai.shen
 * @date: Created in 2018/11/8 18:10
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
