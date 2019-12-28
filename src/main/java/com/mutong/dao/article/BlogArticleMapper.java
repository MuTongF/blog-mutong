/*
 *
 * BlogArticleMapper.java
 * Copyright(C)  MuTong
 * @date 2019-12-23
 */
package com.mutong.dao.article;

import com.mutong.dao.BaseMapper;
import com.mutong.entity.article.BlogArticleWithBLOBs;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface BlogArticleMapper extends BaseMapper<BlogArticleWithBLOBs> {

  /**
   * 添加阅读量
   */
  int addViews(long id);

  List<BlogArticleWithBLOBs> select(@Param("param") Map<String, Object> map);

  /**
   * @mbggenerated 2019-12-23
   */
  @Override
  BlogArticleWithBLOBs selectByPrimaryKey(Long id);

  /**
   * @mbggenerated 2019-12-26
   */
  int updateByPrimaryKeyWithBLOBs(BlogArticleWithBLOBs record);
}