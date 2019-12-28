package com.mutong.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mutong.common.LayuiJson;
import com.mutong.common.PageResult;
import com.mutong.dao.article.BlogCategoryMapper;
import com.mutong.entity.article.BlogCategory;
import com.mutong.service.CategoryService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private BlogCategoryMapper categoryMapper;

  @Override
  public LayuiJson save(BlogCategory category) {
    return (category.getId() != null) ? update(category) : insert(category);
  }

  private LayuiJson insert(BlogCategory category) {
    List<BlogCategory> blogCategories = selectByName(category.getName());
    if (blogCategories.size() > 0) {
      return LayuiJson.newErrorInstance("该分类已存在");
    }

    int i = categoryMapper.insertSelective(category);
    return (i == 1) ? LayuiJson.newInstance("添加成功") : LayuiJson.newErrorInstance("添加失败");
  }

  private LayuiJson update(BlogCategory category) {
    int i = categoryMapper.updateByPrimaryKeySelective(category);
    return (i == 1) ? LayuiJson.newInstance("修改成功") : LayuiJson.newErrorInstance("修改失败");
  }

  private List<BlogCategory> selectByName(String name) {
    return categoryMapper.selectByName(name);
  }

  @Override
  public LayuiJson delete(long id) {
    int i = categoryMapper.deleteByPrimaryKey(id);
    return (i == 1) ? LayuiJson.newInstance("删除成功") : LayuiJson.newErrorInstance("删除失败");
  }

  @Override
  public PageResult page(PageResult pageResult, Map<String, Object> map) {
    Page<Object> page = PageHelper.startPage(pageResult.getPage(), pageResult.getLimit());
    List<BlogCategory> list = categoryMapper.selectAll(map);
    return pageResult.New(page.getTotal(), list);
  }

  @Override
  public List<BlogCategory> selectAll() {
    return categoryMapper.selectAll(null);
  }
}
