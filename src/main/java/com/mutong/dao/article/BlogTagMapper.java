/*
 *
 * BlogTagMapper.java
 * Copyright(C)  MuTong
 * @date 2019-12-23
 */
package com.mutong.dao.article;

import com.mutong.dao.BaseMapper;
import com.mutong.entity.article.BlogTag;
import java.util.List;

public interface BlogTagMapper extends BaseMapper<BlogTag> {

  List<BlogTag> selectAll(BlogTag tag);

  BlogTag selectByName(String name);

}