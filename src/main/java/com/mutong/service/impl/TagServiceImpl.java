package com.mutong.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mutong.common.LayuiJson;
import com.mutong.common.PageResult;
import com.mutong.dao.article.BlogTagMapper;
import com.mutong.entity.article.BlogTag;
import com.mutong.service.TagService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

  @Autowired
  private BlogTagMapper blogTagMapper;

  @Override
  public LayuiJson insert(BlogTag tag) {
    BlogTag blogTag = selectByName(tag.getName());
    if (blogTag != null) {
      return LayuiJson.newErrorInstance("此标签已存在");
    }

    return (tag.getId() == null) ? ((blogTagMapper.insertSelective(tag) == 1) ? LayuiJson
        .newInstance("保存成功")
        : LayuiJson.newErrorInstance("保存失败")) : update(tag);
  }

  @Override
  public LayuiJson update(BlogTag tag) {
    int i = blogTagMapper.updateByPrimaryKey(tag);
    return (i == 1) ? LayuiJson.newInstance("修改成功") : LayuiJson.newErrorInstance("修改失败");
  }

  @Override
  public LayuiJson delete(Long id) {
    int i = blogTagMapper.deleteByPrimaryKey(id);
    return (i == 1) ? LayuiJson.newInstance("删除成功") : LayuiJson.newErrorInstance("删除失败");
  }

  @Override
  public PageResult page(PageResult pageResult, BlogTag tag) {
    Page page = PageHelper.startPage(pageResult.getPage(), pageResult.getLimit());
    List<BlogTag> blogTags = blogTagMapper.selectAll(tag);
    return pageResult.New(page.getTotal(), blogTags);
  }

  @Override
  public List<BlogTag> selectAll() {
    return blogTagMapper.selectAll(null);
  }

  @Override
  public BlogTag selectByName(String name) {
    return blogTagMapper.selectByName(name);
  }
}
