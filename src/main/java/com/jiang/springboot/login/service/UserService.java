package com.jiang.springboot.login.service;

import com.jiang.springboot.login.bean.UserInfo;
import com.jiang.springboot.login.mapper.UserMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  public List<UserInfo> queryUserInfoAll() {
    return userMapper.batchUserInfoAll();
  }
}
