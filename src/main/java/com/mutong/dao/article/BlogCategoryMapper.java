/*
 *
 * BlogCategoryMapper.java
 * Copyright(C)  MuTong
 * @date 2019-12-23
 */
package com.mutong.dao.article;

import com.mutong.dao.BaseMapper;
import com.mutong.entity.article.BlogCategory;
import java.util.List;
import java.util.Map;

public interface BlogCategoryMapper extends BaseMapper<BlogCategory> {

  List<BlogCategory> selectAll(Map<String, Object> map);

  List<BlogCategory> selectByName(String name);
}