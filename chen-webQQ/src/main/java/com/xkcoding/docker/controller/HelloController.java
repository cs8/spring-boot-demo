package com.xkcoding.docker.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xkcoding.docker.common.ApiResponse;
import com.xkcoding.docker.common.DataType;
import com.xkcoding.docker.common.ParamType;
import com.xkcoding.docker.entity.Message;
import com.xkcoding.docker.entity.User;
import com.xkcoding.docker.service.MessageService;
import com.xkcoding.docker.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * Hello Controller
 * </p>
 *
 * @package: com.xkcoding.docker.controller
 * @description: Hello Controller
 * @author: yangkai.shen
 * @date: Created in 2018-11-29 14:58
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@RestController
@RequestMapping
@Slf4j
public class HelloController {
  @Autowired
  private UserService userService;

  @Autowired
  private MessageService messageService;


  @ApiOperation(value = "条件查询（DONE）", notes = "备注")
  @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户名", dataType = DataType.STRING, paramType = ParamType.QUERY, defaultValue = "xxx")})
    @GetMapping("/hello")
    public String hello() {
        return "Hello,From Docker! haha!!!";
    }


  @GetMapping(value="/add")
  @ApiImplicitParams({@ApiImplicitParam(name = "who", value = "用户名", dataType = DataType.STRING, paramType = ParamType.QUERY, defaultValue = "xxx"),
    @ApiImplicitParam(name = "msg", value = "消息", dataType = DataType.STRING, paramType = ParamType.QUERY, defaultValue = "")
  })

  public String addUser(@RequestParam( name = "who") String who, @RequestParam( name = "id") String id){

    String salt = IdUtil.fastSimpleUUID();
    User testSave3 = User.builder().name(who).password(SecureUtil.md5("123456" + salt)).salt(salt).email("12345@qq.com").phoneNumber("15392951861").status(1).lastLoginTime(new DateTime()).build();
    boolean save = userService.save(testSave3);
    log.debug("【测试id回显#testSave3.getId()】= {}", testSave3.getId());

    return who+"said:"+id;
  }

  @GetMapping(value="/addMessage")

  public String addMessage(@RequestParam( name = "userId") String userId, @RequestParam( name = "msg") String msg){

    String salt = IdUtil.fastSimpleUUID();
    Message message = Message.builder().userId(userId).content(msg).createTime(new DateTime()).build();
    boolean save = messageService.save(message);
    log.debug("保存成功【测试id回显#testSave3.getId()】=", message.getId());

    return userId+"said:"+msg;
   }
  @GetMapping(value="/getAllMessage")
   public ApiResponse getAllMessage(){
    List<Message> list = messageService.list(new QueryWrapper<>());
    Assert.isTrue(CollUtil.isNotEmpty(list));
    log.debug("【list】= {}", list);
//    return ApiResponse .<List<Message>>builder().code(200)
//      .message("操作成功")
//      .data(list)
//      .build();
    return ApiResponse.of(200,"ok",list);
  }

  /**
   * 测试Mybatis-Plus 批量新增
   */
//  @Test
//  public void testSaveList() {
//    List<User> userList = Lists.newArrayList();
//    for (int i = 4; i < 14; i++) {
//      String salt = IdUtil.fastSimpleUUID();
//      User user = User.builder().name("testSave" + i).password(SecureUtil.md5("123456" + salt)).salt(salt).email("testSave" + i + "@xkcoding.com").phoneNumber("1730000000" + i).status(1).lastLoginTime(new DateTime()).build();
//      userList.add(user);
//    }
//    boolean batch = userService.saveBatch(userList);
//    Assert.assertTrue(batch);
//    List<Long> ids = userList.stream().map(User::getId).collect(Collectors.toList());
//    log.debug("【userList#ids】= {}", ids);
//  }

//  /**
//   * 测试Mybatis-Plus 删除
//   */
  @GetMapping(value="/deleteMessage")
  public ApiResponse DeleteMessage(@RequestParam( name = "messageId") String messageId) {
    boolean remove = messageService.removeById(messageId);
    Assert.isTrue(remove);
    return ApiResponse.of(200,"ok","");
  }
//
//  /**
//   * 测试Mybatis-Plus 修改
//   */
//  @Test
//  public void testUpdate() {
//    User user = userService.getById(1L);
//    Assert.assertNotNull(user);
//    user.setName("MybatisPlus修改名字");
//    boolean b = userService.updateById(user);
//    Assert.assertTrue(b);
//    User update = userService.getById(1L);
//    Assert.assertEquals("MybatisPlus修改名字", update.getName());
//    log.debug("【update】= {}", update);
//  }
//
//  /**
//   * 测试Mybatis-Plus 查询单个
//   */
//  @Test
//  public void testQueryOne() {
//    User user = userService.getById(1L);
//    Assert.assertNotNull(user);
//    log.debug("【user】= {}", user);
//  }
//
//  /**
//   * 测试Mybatis-Plus 查询全部
//   */
//  @Test
//  public void testQueryAll() {
//    List<User> list = userService.list(new QueryWrapper<>());
//    Assert.assertTrue(CollUtil.isNotEmpty(list));
//    log.debug("【list】= {}", list);
//  }
//
//  /**
//   * 测试Mybatis-Plus 分页排序查询
//   */
//  @Test
//  public void testQueryByPageAndSort() {
//    initData();
//    int count = userService.count(new QueryWrapper<>());
//    Page<User> userPage = new Page<>(1, 5);
//    userPage.setDesc("id");
//    IPage<User> page = userService.page(userPage, new QueryWrapper<>());
//    Assert.assertEquals(5, page.getSize());
//    Assert.assertEquals(count, page.getTotal());
//    log.debug("【page.getRecords()】= {}", page.getRecords());
//  }
//
//  /**
//   * 测试Mybatis-Plus 自定义查询
//   */
//  @Test
//  public void testQueryByCondition() {
//    initData();
//    QueryWrapper<User> wrapper = new QueryWrapper<>();
//    wrapper.like("name", "Save1").or().eq("phone_number", "17300000001").orderByDesc("id");
//    int count = userService.count(wrapper);
//    Page<User> userPage = new Page<>(1, 3);
//    IPage<User> page = userService.page(userPage, wrapper);
//    Assert.assertEquals(3, page.getSize());
//    Assert.assertEquals(count, page.getTotal());
//    log.debug("【page.getRecords()】= {}", page.getRecords());
//  }


}
