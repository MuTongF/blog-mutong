package com.mutong.service;

import com.mutong.common.LayuiJson;
import com.mutong.common.PageResult;
import com.mutong.entity.article.BlogTag;
import java.util.List;

public interface TagService {

  LayuiJson insert(BlogTag tag);

  LayuiJson update(BlogTag tag);

  LayuiJson delete(Long id);

  PageResult page(PageResult pageResult, BlogTag tag);

  List<BlogTag> selectAll();

  BlogTag selectByName(String name);

}
