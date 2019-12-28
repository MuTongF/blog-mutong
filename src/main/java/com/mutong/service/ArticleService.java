package com.mutong.service;

import com.mutong.common.LayuiJson;
import com.mutong.common.PageResult;
import com.mutong.entity.article.BlogArticleWithBLOBs;
import java.util.Map;

public interface ArticleService {

  /**
   * 保存文章(添加/修改)
   *
   * @param article 文章对象
   */
  LayuiJson save(BlogArticleWithBLOBs article);

  /**
   * 删除文章
   */
  LayuiJson delete(Long id);

  /**
   * 主键查询
   */
  BlogArticleWithBLOBs selectById(Long id);

  /**
   * 增加浏览量
   */
  void addViews(Long id);

  /**
   * 查询文章分页
   *
   * @param data 分页参数
   * @param map 查询条件
   * @return 分页信息
   */
  PageResult page(PageResult data, Map<String, Object> map);
}
