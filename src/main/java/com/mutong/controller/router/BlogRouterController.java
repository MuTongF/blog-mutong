package com.mutong.controller.router;

import com.mutong.common.PageResult;
import com.mutong.entity.article.BlogArticleWithBLOBs;
import com.mutong.exception.MuTongException;
import com.mutong.service.ArticleService;
import com.mutong.util.TimeUtil;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Api(tags = "博客路由")
public class BlogRouterController {

  @Autowired
  private ArticleService articleService;

  @GetMapping({"", "/", "/page/{page}"})
  public String index(@PathVariable(required = false) Integer page, Model model) {
    String img = "/blog/images/home-images/image-";

    return "views/blog/index";
  }

  private static int random(int lenght) {
    int i = (int) (Math.random() * lenght * 1);
    return i;
  }

  @GetMapping("/about")
  public String about() {
    return "views/blog/about";
  }

  @GetMapping("/article/{id}")
  public String detail(@PathVariable(value = "id", required = false) String idStr, Model model) {
    if (idStr != null) {
      Long id = new Long(idStr);
      BlogArticleWithBLOBs blogArticleWithBLOBs = articleService.selectById(id);
      if (blogArticleWithBLOBs == null) {
        throw new MuTongException(404, "没有此文章");
      }
      articleService.addViews(id);
      blogArticleWithBLOBs.setViews(blogArticleWithBLOBs.getViews() + 1);
      model.addAttribute("article", blogArticleWithBLOBs);
    }
    return "views/blog/article";
  }

  public static void main(String[] args) {
    System.out.println(TimeUtil.GetStringDate(new Date(), "yyyy MM,dd - EEEE"));
  }

  @GetMapping({"/blog", "/blog/page/{page}"})
  public String blog(@PathVariable(required = false) Integer page, Model model) {
    if (page == null) {
      page = 1;
    }
    PageResult pag = new PageResult();
    pag.setPage(page);
    pag.setLimit(20);
    Map<String, Object> map = new HashMap<>();

    PageResult pageResult = articleService.page(pag, map);
    List data = pageResult.getData();
    List<BlogArticleWithBLOBs> list = new ArrayList();
    for (int i = 0; i < data.size(); i++) {
      BlogArticleWithBLOBs art = (BlogArticleWithBLOBs) data.get(i);
      String content = Jsoup.parse(art.getContent()).text();
      if (content.length() > 50) {
        content = content.substring(0, 40) + "...";
      }
      art.setContent(content);
      list.add(art);
    }
    model.addAttribute("page", pageResult.getPage());
    model.addAttribute("pageCount", (pageResult.getCount() + pag.getLimit() - 1) / pag.getLimit());
    model.addAttribute("list", list);
    return "views/blog/blog";
  }

  @GetMapping("/contact")
  public String contanct() {
    return "views/blog/contact";
  }

}
