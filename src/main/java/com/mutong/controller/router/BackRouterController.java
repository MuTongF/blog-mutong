package com.mutong.controller.router;

import com.mutong.entity.article.BlogArticleWithBLOBs;
import com.mutong.entity.article.BlogCategory;
import com.mutong.entity.article.BlogTag;
import com.mutong.service.ArticleService;
import com.mutong.service.CategoryService;
import com.mutong.service.TagService;
import io.swagger.annotations.Api;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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
  public String articleList(Model model) {
    List<BlogTag> tags = tagService.selectAll();
    List<BlogCategory> categories = categoryService.selectAll();
    model.addAttribute("tags", tags);
    model.addAttribute("categories", categories);
    return "views/back/article/list";
  }

  @Autowired
  private TagService tagService;
  @Autowired
  private CategoryService categoryService;
  @Autowired
  private ArticleService articleService;
  @GetMapping("/article/add")
  public String addArtPage(String id, Model model) {
    List<BlogTag> tags = tagService.selectAll();
    List<BlogCategory> categories = categoryService.selectAll();

    if (id != null) {
      Long idd = new Long(id);
      BlogArticleWithBLOBs article = articleService.selectById(idd);
      model.addAttribute("article", article);
    }
    model.addAttribute("tags", tags);
    model.addAttribute("categories", categories);
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

  @GetMapping("/test/layui_md")
  public String layuiMd() {
    return "views/back/test/layui_md";
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
