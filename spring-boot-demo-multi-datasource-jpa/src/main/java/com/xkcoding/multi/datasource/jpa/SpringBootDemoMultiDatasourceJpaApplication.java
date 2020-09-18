package com.xkcoding.multi.datasource.jpa;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 启动器
 * </p>
 *
 * @package: com.xkcoding.multi.datasource.jpa
 * @description: 启动器
 * @author: yangkai.shen
 * @date: Created in 2019-01-16 17:34
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangkai.shen
 */
@SpringBootApplication
@RestController
public class SpringBootDemoMultiDatasourceJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoMultiDatasourceJpaApplication.class, args);
    }
  /**
   * Hello，World
   *
   * @param who 参数，非必须
   * @return Hello, ${who}
   */
  @GetMapping("/hello")
  public String sayHello(@RequestParam(required = false, name = "who") String who) {
    if (StrUtil.isBlank(who)) {
      who = "World";
    }
    return StrUtil.format("Hello, {}!", who);
  }
}

