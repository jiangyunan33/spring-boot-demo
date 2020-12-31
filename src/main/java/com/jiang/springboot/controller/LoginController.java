package com.jiang.springboot.controller;

import com.jiang.springboot.bean.UserInfo;
import com.jiang.springboot.login.WebSecurityConfig;
import com.jiang.springboot.service.LoginService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

  @Autowired
  private LoginService loginService;

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/loginVerify")
  public String loginVerity(String userName, String password, HttpSession session) {
    System.out.println(userName + "," + password);
    UserInfo info = new UserInfo();
    info.setUserName(userName);
    info.setPassword(password);
    boolean isVerify = loginService.loginVerify(info);

    if (isVerify) {
      session.setAttribute(WebSecurityConfig.SESSION_KEY, userName);
      return "result/success";
    }
    return "result/error";
  }
}
