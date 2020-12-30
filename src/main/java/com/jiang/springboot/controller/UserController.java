package com.jiang.springboot.controller;

import com.jiang.springboot.bean.UserInfo;
import com.jiang.springboot.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/userInfo")
  @ResponseBody
  public List<UserInfo> queryUserInfo() {
    return userService.queryUserInfoAll();
  }
}
