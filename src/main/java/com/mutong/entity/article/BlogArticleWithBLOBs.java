/*
*
* BlogArticleWithBLOBs.java
* Copyright(C)  MuTong
* @date 2019-12-23
*/
package com.mutong.entity.article;

public class BlogArticleWithBLOBs extends BlogArticle {
    /* 内容 */

    private String content;

    /* 内容-md */

    private String contentMd;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getContentMd() {
        return contentMd;
    }

    public void setContentMd(String contentMd) {
        this.contentMd = contentMd == null ? null : contentMd.trim();
    }
}