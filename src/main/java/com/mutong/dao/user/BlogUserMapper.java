/*
 *
 * BlogUserMapper.java
 * Copyright(C)  MuTong
 * @date 2019-12-17
 */
package com.mutong.dao.user;

import com.mutong.dao.BaseMapper;
import com.mutong.entity.user.BlogUser;
import java.util.List;
import java.util.Map;

public interface BlogUserMapper extends BaseMapper<BlogUser> {

  List<BlogUser> pageFind(Map<String, Object> map);

  BlogUser selectByUserName(String username);
}