package com.xkcoding.cache.redis.controller;

import cn.hutool.json.JSON;
import com.xkcoding.cache.redis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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
	@GetMapping(value = { "/noone"})
	public String noOne() {


	  return "I am noone. But I know redis";
	}
  @GetMapping(value="/redisAdd")
  public String saveRedis(@RequestParam( name = "who") String who,@RequestParam( name = "key") String key){
    stringRedisTemplate.opsForValue().set(key,who);
    return "add success.";
  }
  @GetMapping(value="/redisGet")
  public String getRedis(){
    return stringRedisTemplate.opsForValue().get("mykey");
  }

  @GetMapping(value="/addStu")
  public String addStu(@RequestParam(required = true, name = "name")String name,@RequestParam(required = true, name = "id")Long id){
    User user =new User(id,name);
    stringRedisTemplate.opsForValue().set(id+"",user.toString());

	  return  "addSuccess";

  }
  @GetMapping(value="/getStu")
  public String getStu(@RequestParam(required = true, name = "id")String id){
    return stringRedisTemplate.opsForValue().get(id);
  }

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

}
