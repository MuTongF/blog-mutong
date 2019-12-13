package com.mutong.controller.router;

import io.swagger.annotations.Api;
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
  public String login() {
    return "views/user/login";
  }

  @GetMapping("/admin/page/index")
  public String index() {
    return "views/home/console";
  }
}
