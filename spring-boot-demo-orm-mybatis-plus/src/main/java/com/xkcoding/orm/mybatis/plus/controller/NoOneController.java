package com.xkcoding.orm.mybatis.plus.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.xkcoding.orm.mybatis.plus.entity.User;
import com.xkcoding.orm.mybatis.plus.mapper.UserMapper;
import com.xkcoding.orm.mybatis.plus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 首页
 * </p>
 *
 * @package: com.xkcoding.admin.client.controller
 * @description: 首页
 * @author: yangkai.shen
 * @date: Created in 2018/10/8 2:15 PM
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@RestController
@Slf4j
public class NoOneController {

  @Autowired
  private UserService userService;



  @GetMapping(value = { "/noone"})
	public String noOne() {


	  return "I am noone. But I know redis";
	}
  @GetMapping(value="/add")
  public String saveRedis(@RequestParam( name = "who") String who,@RequestParam( name = "msg") String msg){

    String salt = IdUtil.fastSimpleUUID();
    User testSave3 = User.builder().name(who).password(SecureUtil.md5("123456" + salt)).salt(salt).email("12345@qq.com").phoneNumber("15392951861").status(1).lastLoginTime(new DateTime()).build();
    boolean save = userService.save(testSave3);
    log.debug("【测试id回显#testSave3.getId()】= {}", testSave3.getId());

       return who+"said:"+msg;
  }


}
