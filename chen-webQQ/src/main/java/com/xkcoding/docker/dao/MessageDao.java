package com.xkcoding.docker.dao;

import com.xkcoding.docker.entity.Message;
import com.xkcoding.docker.entity.User;

import java.util.List;

/**
 * Created by LS on 2019/11/1 0001.
 */
public interface MessageDao {

    /**
     * 根据id查询消息信息
     *
     * @param id
     * @return
     */
    public Message queryMessageById(String id);

    /**
     * 查询所有消息信息
     *
     * @return
     */
    public List<Message> queryMessageAll();

    /**
     * 新增消息
     *
     * @param message
     */
    public void insertMessage(Message message);

    /**
     * 更新用户信息
     *
     * @param message
     */
    public void updateMessage(Message message);

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    public void deleteMessage(String id);
  }


