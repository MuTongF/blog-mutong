package com.mutong.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

  @RequestMapping({"/"})
  public String error() {
    return "error/error";
  }

  @RequestMapping("/404")
  public String error_404() {
    return "error/404";
  }
}
