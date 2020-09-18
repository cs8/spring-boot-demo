package com.xkcoding.async.task;

import org.springframework.web.bind.annotation.GetMapping;
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
    TaskFactory factory =new TaskFactory();
    try {
      factory.asyncTask1();
      factory.asyncTask2();
      factory.asyncTask3();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

	  return "I am noone.";
	}


}
