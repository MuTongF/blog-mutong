package com.mutong.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mutong.common.LayuiJson;
import com.mutong.common.PageResult;
import com.mutong.dao.article.BlogArticleMapper;
import com.mutong.entity.article.BlogArticleWithBLOBs;
import com.mutong.service.ArticleService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

  @Autowired
  private BlogArticleMapper articleMapper;

  @Override
  public LayuiJson save(BlogArticleWithBLOBs article) {
    return (article.getId() != null) ? update(article) : insert(article);
  }

  @Override
  public LayuiJson delete(Long id) {
    int i = articleMapper.deleteByPrimaryKey(id);
    return (i == 1) ? LayuiJson.newInstance("删除成功") : LayuiJson.newErrorInstance("删除失败");
  }

  @Override
  public BlogArticleWithBLOBs selectById(Long id) {
    return articleMapper.selectByPrimaryKey(id);
  }

  @Override
  public void addViews(Long id) {
    articleMapper.addViews(id);
  }

  @Override
  public PageResult page(PageResult data, Map<String, Object> map) {
    Page<Object> page = PageHelper.startPage(data.getPage(), data.getLimit());
    List<BlogArticleWithBLOBs> list = articleMapper.select(map);
    return data.New(page.getTotal(), list);
  }

  private LayuiJson insert(BlogArticleWithBLOBs article) {
    article.setCreatTime(new Date());
    int i = articleMapper.insertSelective(article);
    return (i == 1) ? LayuiJson.newInstance("添加成功") : LayuiJson.newErrorInstance("添加失败");
  }

  private LayuiJson update(BlogArticleWithBLOBs article) {
    article.setUpdateTime(new Date());
    int i = articleMapper.updateByPrimaryKeySelective(article);
    return (i == 1) ? LayuiJson.newInstance("修改成功") : LayuiJson.newErrorInstance("修改失败");
  }

}
