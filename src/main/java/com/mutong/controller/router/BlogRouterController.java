package com.mutong.controller.router;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogRouterController {

  @GetMapping("/")
  public String index() {
    return "views/blog/index";
  }
}
