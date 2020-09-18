package com.xkcoding.docker.Impl;

import com.xkcoding.docker.dao.MessageDao;
import com.xkcoding.docker.entity.Message;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by LS on 2019/11/1 0001.
 */
public class MessageDaoImpl implements MessageDao {
  public SqlSession sqlSession;

  public MessageDaoImpl(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public Message queryMessageById(String id) {
    return this.sqlSession.selectOne("MessageDao.queryMessageById", id);
  }

  @Override
  public List<Message> queryMessageAll() {
    return this.sqlSession.selectList("MessageDao.queryMessageAll");
  }

  @Override
  public void insertMessage(Message Message) {
    this.sqlSession.insert("MessageDao.insertMessage", Message);
  }

  @Override
  public void updateMessage(Message Message) {
    this.sqlSession.update("MessageDao.updateMessage", Message);
  }

  @Override
  public void deleteMessage(String id) {
    this.sqlSession.delete("MessageDao.deleteMessage", id);
  }

}
