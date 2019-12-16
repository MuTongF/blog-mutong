package com.mutong.controller.router;

import io.swagger.annotations.Api;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 博客后台路由
 */
@Controller
@Api("后台路由")
@RequestMapping("back")
public class BackRouterController {

  @GetMapping("/login")
  public String login(HttpSession session) {
    /*清除session*/
    session.invalidate();
    return "views/user/login";
  }

  @GetMapping("/home/console")
  public String console() {
    return "views/home/console";
  }

  @GetMapping("/home/homepage")
  public String homepage() {
    return "views/home/homepage1";
  }

  @GetMapping("/component/button/index")
  public String button() {
    return "views/component/button/index";
  }

  @GetMapping("/search")
  public String search(String keywords) {
    System.out.println(keywords);
    return "views/template/search";
  }

  @GetMapping("/index")
  public String index() {
    return "views/index";
  }
}
