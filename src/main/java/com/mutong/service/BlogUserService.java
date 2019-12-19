package com.mutong.service;

import com.mutong.common.LayuiJson;
import com.mutong.common.PageResult;
import com.mutong.entity.user.BlogUser;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public interface BlogUserService {

  /**
   * 分页-条件查询
   */
  PageResult pageFind(PageResult pageResult, Map<String, Object> map);

  /**
   * 注册
   */
  LayuiJson register(BlogUser user);

  /**
   * 修改
   */
  LayuiJson update(BlogUser user);

  /**
   * 通过id查询
   */
  BlogUser selectById(long id);

  /**
   * 通过用户名查询
   */
  BlogUser selectByUserName(String username);

}
