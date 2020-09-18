package com.xkcoding.docker.Impl;

import com.xkcoding.docker.dao.UserDao;
import com.xkcoding.docker.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by LS on 2019/11/1 0001.
 */
public class UserDaoImpl implements UserDao {
  public SqlSession sqlSession;

  public UserDaoImpl(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public User queryUserById(String id) {
    return this.sqlSession.selectOne("UserDao.queryUserById", id);
  }

  @Override
  public List<User> queryUserAll() {
    return this.sqlSession.selectList("UserDao.queryUserAll");
  }

  @Override
  public void insertUser(User user) {
    this.sqlSession.insert("UserDao.insertUser", user);
  }

  @Override
  public void updateUser(User user) {
    this.sqlSession.update("UserDao.updateUser", user);
  }

  @Override
  public void deleteUser(String id) {
    this.sqlSession.delete("UserDao.deleteUser", id);
  }

}
