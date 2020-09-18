package com.xkcoding.docker.controller;

import com.xkcoding.docker.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Hello Controller
 * </p>
 *
 * @package: com.xkcoding.docker.controller
 * @description: Login Controller
 * @author: yangkai.shen
 * @date: Created in 2018-11-29 14:58
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@RestController
@RequestMapping
public class LoginController {
    @GetMapping("/login")
    public User hello(@RequestParam( name = "username") String who, @RequestParam( name = "password") String msg) {

      User user = new User();
      user.setName(who);
      user.setPassword(msg);
      return user;
    }
}
