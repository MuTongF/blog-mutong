package com.mutong.controller.back;

import com.mutong.common.LayuiJson;
import com.mutong.common.PageResult;
import com.mutong.entity.article.BlogTag;
import com.mutong.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

  @Autowired
  private TagService tagService;

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
}
