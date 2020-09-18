package com.xkcoding.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 * 启动器
 * </p>
 *
 * @package: com.xkcoding.docker
 * @description: 启动器
 * @author: yangkai.shen
 * @date: Created in 2018-11-29 14:59
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@SpringBootApplication
public class webQQApplication {

    public static void main(String[] args) {
        SpringApplication.run(webQQApplication.class, args);
    }

  /**
   * 资源映射路径
   */
  @Configuration
  public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/image/**").addResourceLocations("file:E://tmp/work/Tomcat/localhost/demo/");
    }
  }

}
