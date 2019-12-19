package com.mutong.controller.router;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Api(tags = "博客路由")
public class BlogRouterController {

  @GetMapping({"", "/", "/page/{page}"})
  public String index(@PathVariable(required = false) Integer page, Model model) {
    if (page == null) {
      page = 1;
    }
    return "views/blog/index";
  }

  @GetMapping("/about")
  public String about() {
    return "views/blog/about";
  }

  @GetMapping({"/blog", "/blog/page/{page}"})
  public String blog(@PathVariable(required = false) Integer page, Model model) {
    if (page == null) {
      page = 1;
    }
    return "views/blog/blog";
  }

  @GetMapping("/contact")
  public String contanct() {
    return "views/blog/contact";
  }

}
