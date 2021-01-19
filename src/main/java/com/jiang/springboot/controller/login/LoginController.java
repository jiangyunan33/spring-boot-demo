package com.jiang.springboot.controller.login;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jiang.springboot.login.WebSecurityConfig;
import com.jiang.springboot.login.bean.UserInfo;
import com.jiang.springboot.login.service.LoginService;


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
        return "loginError";
    }

    @GetMapping("/select")
    public String select(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account,
                         Model model) {
        return "result/select";
    }

    @GetMapping("/login-out")
    public String loginOut(HttpSession session) {
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:login";
    }
}
