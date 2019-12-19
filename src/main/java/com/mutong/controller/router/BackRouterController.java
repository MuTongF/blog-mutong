package com.mutong.controller.router;

import io.swagger.annotations.Api;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

  @GetMapping("/article/list")
  public String articleList() {
    return "views/back/article/list";
  }

  @GetMapping("/article/add")
  public String addArtPage(Integer id, Model model) {
    return "views/back/article/add";
  }

  @GetMapping("/article/comment")
  public String comment() {
    return "views/back/article/comment";
  }

  @GetMapping("/article/tags")
  public String tags() {
    return "views/back/article/tags";
  }

  @GetMapping("/user/set/info")
  public String homepage() {
    return "views/set/user/info";
  }

  @GetMapping("/user/set/password")
  public String updatePassword() {
    return "views/set/user/password";
  }

  @GetMapping("/set/system/email")
  public String email() {
    return "views/set/system/email";
  }

  @GetMapping("/set/system/website")
  public String website() {
    return "views/set/system/website";
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
