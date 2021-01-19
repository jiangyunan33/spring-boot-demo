package com.jiang.springboot.login.service;


import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiang.springboot.login.bean.UserInfo;
import com.jiang.springboot.login.mapper.UserMapper;


@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    public boolean loginVerify(UserInfo userInfo) {
        List<UserInfo> userList = userMapper.queryUserInfo(userInfo.getUserName(),
                userInfo.getPassword());
        System.out.println(userList);
        return CollectionUtils.isNotEmpty(userList);
    }
}
