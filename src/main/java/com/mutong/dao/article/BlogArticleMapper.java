/*
 *
 * BlogArticleMapper.java
 * Copyright(C)  MuTong
 * @date 2019-12-23
 */
package com.mutong.dao.article;

import com.mutong.dao.BaseMapper;
import com.mutong.entity.article.BlogArticle;
import com.mutong.entity.article.BlogArticleWithBLOBs;
import java.util.List;

public interface BlogArticleMapper extends BaseMapper<BlogArticle> {

  /**
   * 添加阅读量
   */
  int addViews(long id);

  List<BlogArticle> selectAll(BlogArticle article);

  /**
   * @mbggenerated 2019-12-23
   */
  @Override
  BlogArticleWithBLOBs selectByPrimaryKey(Long id);
}