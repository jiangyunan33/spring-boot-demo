package com.jiang.springboot.login.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiang.springboot.login.bean.UserInfo;
import com.jiang.springboot.login.mapper.UserMapper;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserInfo> queryUserInfoAll() {
        return userMapper.batchUserInfoAll();
    }
}
