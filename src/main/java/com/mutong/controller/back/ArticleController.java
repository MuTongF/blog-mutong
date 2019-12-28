package com.mutong.controller.back;

import com.alibaba.fastjson.JSONObject;
import com.mutong.common.LayuiJson;
import com.mutong.common.PageResult;
import com.mutong.entity.article.BlogArticleWithBLOBs;
import com.mutong.entity.article.BlogCategory;
import com.mutong.entity.article.BlogTag;
import com.mutong.entity.user.BlogUser;
import com.mutong.service.ArticleService;
import com.mutong.service.CategoryService;
import com.mutong.service.TagService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

  @Autowired
  private TagService tagService;
  @Autowired
  private CategoryService categoryService;
  @Autowired
  private ArticleService articleService;
  @Value("${spring.profiles.active}")
  private String action;

  @RequestMapping("/page")
  public PageResult page(PageResult pageResult,
      @RequestParam(value = "map", required = false) String mapStr) {
    Map<String, Object> map = JSONObject.parseObject(mapStr);

    return articleService.page(pageResult, map);
  }

  @PostMapping("/save")
  public LayuiJson save(BlogArticleWithBLOBs article, HttpSession session) {
    Object user = session.getAttribute("user");
    if (user != null) {
      BlogUser blogUser = (BlogUser) user;
      article.setUserId(blogUser.getId());
      article.setAuthor(blogUser.getAuthorName());
    } else {
      article.setAuthor(StringUtils.upperCase(action.substring(0, 1)) + action.substring(1, action.length()));
    }
    return articleService.save(article);
  }

  @PostMapping("/delete")
  public LayuiJson delete(long id) {
    return articleService.delete(id);
  }


  @PostMapping("/tag/page")
  public PageResult tagPage(PageResult pageResult, BlogTag tag) {
    PageResult page = tagService.page(pageResult, tag);
    return page;
  }

  @PostMapping("/tag/save")
  public LayuiJson tagSave(BlogTag tag) {
    return tagService.insert(tag);
  }

  @PostMapping("/tag/delete")
  public LayuiJson tagDel(long id) {
    return tagService.delete(id);
  }

  @PostMapping("/category/page")
  public PageResult categoryPage(PageResult pageResult, Map<String, Object> map) {
    PageResult page = categoryService.page(pageResult, map);
    return page;
  }

  @PostMapping("/category/save")
  public LayuiJson categorySave(BlogCategory category) {
    return categoryService.save(category);
  }

  @PostMapping("/category/delete")
  public LayuiJson categoryDel(long id) {
    return categoryService.delete(id);
  }
}
