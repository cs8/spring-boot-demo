package com.xkcoding.orm.mybatis;

import com.xkcoding.orm.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @package: com.xkcoding.orm.mybatis
 * @description: 启动类
 * @author: yangkai.shen
 * @date: Created in 2018/11/8 10:52
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@MapperScan(basePackages = {"com.xkcoding.orm.mybatis.mapper"})
@SpringBootApplication
public class SpringBootDemoOrmMybatisApplication {

    public static void main(String[] args) {

      SpringApplication.run(SpringBootDemoOrmMybatisApplication.class, args);


//      // 指定全局配置文件
//      String resource = "mappers/UserMapper.xml";
//      // 读取配置文件
//      InputStream inputStream = null;
//      try {
//        inputStream = Resources.getResourceAsStream(resource);
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//      // 构建sqlSessionFactory
//      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      // 获取sqlSession
//      SqlSession sqlSession = sqlSessionFactory.openSession();
//      try {
//        // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
//        // 第二个参数：指定传入sql的参数：这里是用户id
//        User user = sqlSession.selectOne("MyMapper.selectUser", 1);
//        System.out.println(user);
//      } finally {
//        sqlSession.close();
//      }

    }
}
