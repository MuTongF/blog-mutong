/*
*
* BlogCategory.java
* Copyright(C)  MuTong
* @date 2019-12-23
*/
package com.mutong.entity.article;

public class BlogCategory {
    private Long id;

    /* 分类名称 */

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}