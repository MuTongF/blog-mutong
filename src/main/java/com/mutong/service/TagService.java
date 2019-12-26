package com.mutong.service;

import com.mutong.common.LayuiJson;
import com.mutong.common.PageResult;
import com.mutong.entity.article.BlogTag;

public interface TagService {

  LayuiJson insert(BlogTag tag);

  LayuiJson update(BlogTag tag);

  LayuiJson delete(Long id);

  PageResult page(PageResult pageResult, BlogTag tag);

  BlogTag selectByName(String name);

}
