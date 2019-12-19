package com.mutong.controller;

import com.mutong.common.LayuiJson;
import com.mutong.entity.user.BlogUser;
import com.mutong.service.BlogUserService;
import com.mutong.util.Md5Util;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private BlogUserService blogUserService;
    @PostMapping("login")
    public LayuiJson login(String username, String password, HttpSession session) {
        BlogUser blogUser = blogUserService.selectByUserName(username);
        if (blogUser != null) {
            if (blogUser.getPassword()
                .equals(Md5Util.encryPassWord(password, blogUser.getSalt()))) {
                session.setAttribute("user", blogUser);
            } else {
                return LayuiJson.newErrorInstance("用户名或密码错误");
            }
        } else {
            return LayuiJson.newErrorInstance("用户名或密码错误");
        }

        return LayuiJson.newInstance("登陆成功", blogUser);
    }
}
