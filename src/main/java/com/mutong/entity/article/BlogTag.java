/*
*
* BlogTag.java
* Copyright(C)  MuTong
* @date 2019-12-23
*/
package com.mutong.entity.article;

public class BlogTag {
    private Long id;

    /* 标签名称 */

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