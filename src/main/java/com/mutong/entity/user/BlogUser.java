/*
 *
 * BlogUser.java
 * Copyright(C)  MuTong
 * @date 2019-12-17
 */
package com.mutong.entity.user;

public class BlogUser {

  private Long id;

  /* 用户名 */

  private String username;

  /* 密码 */

  private String password;

  /* 严值 */

  private String salt;

  /* 作者名 */

  private String authorName;

  /* 头像 */

  private String avatar;
  private String email;

  /* 介绍 */

  private String introduce;

  /* 备注 */

  private String remark;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username == null ? null : username.trim();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password == null ? null : password.trim();
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt == null ? null : salt.trim();
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName == null ? null : authorName.trim();
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar == null ? null : avatar.trim();
  }

  public String getIntroduce() {
    return introduce;
  }

  public void setIntroduce(String introduce) {
    this.introduce = introduce == null ? null : introduce.trim();
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }
}