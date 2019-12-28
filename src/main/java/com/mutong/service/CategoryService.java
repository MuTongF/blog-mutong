package com.mutong.service;

import com.mutong.common.LayuiJson;
import com.mutong.common.PageResult;
import com.mutong.entity.article.BlogCategory;
import java.util.List;
import java.util.Map;

public interface CategoryService {

  /**
   * 保存博客分类(添加/修改)
   */
  LayuiJson save(BlogCategory category);

  /**
   * 删除分类
   *
   * @param id 分类id
   */
  LayuiJson delete(long id);

  /**
   * 分页查询分类
   *
   * @param data 分页数据
   * @param map 查询条件
   * @return 分页数据
   */
  PageResult page(PageResult data, Map<String, Object> map);


  List<BlogCategory> selectAll();

}
