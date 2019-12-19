package com.mutong.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mutong.common.LayuiJson;
import com.mutong.common.PageResult;
import com.mutong.dao.user.BlogUserMapper;
import com.mutong.entity.user.BlogUser;
import com.mutong.service.BlogUserService;
import com.mutong.util.Md5Util;
import com.mutong.util.RandomUtil;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogUserServiceImpl implements BlogUserService {

  @Autowired
  private BlogUserMapper blogUserMapper;

  @Override
  public PageResult pageFind(PageResult pageResult, Map<String, Object> map) {
    Page page = PageHelper.startPage(pageResult.getPage(), pageResult.getLimit());
    List list = blogUserMapper.pageFind(map);
    return pageResult.New(page.getTotal(), list);
  }

  @Override
  public LayuiJson register(BlogUser user) {
    if (user.getUsername().isEmpty() || user.getPassword() == null) {
      return LayuiJson.newErrorInstance("参数错误");
    }
    BlogUser blogUser = selectByUserName(user.getUsername());
    if (blogUser != null) {
      return LayuiJson.newErrorInstance("用户名已存在");
    }
    String slat = RandomUtil.getTextRandom(6);
    String encryPassWord = Md5Util.encryPassWord(user.getPassword(), slat);
    user.setSalt(slat);
    user.setPassword(encryPassWord);

    int i = blogUserMapper.insertSelective(user);
    return (i == 1) ? LayuiJson.newInstance("注册成功") : LayuiJson.newErrorInstance("注册失败");
  }

  @Override
  public LayuiJson update(BlogUser user) {
    if (user.getPassword() != null) {
      String salt = RandomUtil.getTextRandom(6);
      String encryPassWord = Md5Util.encryPassWord(user.getPassword(), salt);
      user.setPassword(encryPassWord);
      user.setSalt(salt);
    }
    int i = blogUserMapper.updateByPrimaryKeySelective(user);
    return (i == 1) ? LayuiJson.newInstance("修改成功") : LayuiJson.newErrorInstance("修改失败");
  }

  @Override
  public BlogUser selectById(long id) {
    return blogUserMapper.selectByPrimaryKey(id);
  }

  @Override
  public BlogUser selectByUserName(String username) {
    return blogUserMapper.selectByUserName(username);
  }
}
