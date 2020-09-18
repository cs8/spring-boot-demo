package com.xkcoding.orm.mybatis.controller;


import com.xkcoding.orm.mybatis.mapper.UserMapper;
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
public class NoOneController {

  @Autowired
  private UserMapper userMapper;


	@GetMapping(value = { "/noone"})
	public String noOne() {


	  return "I am noone. But I know redis";
	}
  @GetMapping(value="/add")
  public String saveRedis(@RequestParam( name = "who") String who,@RequestParam( name = "msg") String msg){



       return who+"said:"+msg;
  }


}
