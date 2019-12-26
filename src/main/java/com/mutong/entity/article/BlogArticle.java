/*
*
* BlogArticle.java
* Copyright(C)  MuTong
* @date 2019-12-23
*/
package com.mutong.entity.article;

import java.util.Date;

public class BlogArticle {
    private Long id;

    /* 用户id(作者) */

    private Long userId;

    /* 标题 */

    private String title;

    /* 封面 */

    private String cover;

    /* 作者 */

    private String author;

    /* 分类 */

    private String category;

    /* 标签 */

    private String tag;

    /* 状态:0-草稿;1-发布 */

    private Integer state;

    /* 发布时间 */

    private Date creatTime;

    /* 更新时间 */

    private Date updateTime;

    /* 类型:0原创;1-转载 */

    private Integer type;

    /* 浏览量 */

    private Long views;

    /* 评论权限 */

    private Boolean allowComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Boolean getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(Boolean allowComment) {
        this.allowComment = allowComment;
    }
}