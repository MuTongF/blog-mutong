package com.mutong.common;

import java.util.List;

/**
 * 接受分页信息
 */
public class PageResult<T> {

    /*状态码*/
    private Integer code;
    /*解析提示文本*/
    private String msg;
    /*当前页*/
    private Integer page;
    /*每页条数*/
    private Integer limit;
    /*总条数*/
    private long count;
    /*查询到的数据*/
    private List<T> data;

    public static PageResult newInstance(long count, List list) {
        return new PageResult(0, count, list);
    }

    public PageResult New(long count, List list) {
        return new PageResult((count == 0) ? 201 : 0, (count == 0) ? "没有数据 (๑•̀ㅂ•́)و✧" : "",
            this.page,
            this.limit, count, list);
    }

    public static PageResult newErrorInstance(Integer code, String msg) {
        return new PageResult(code, msg, null, null, 0, null);
    }


    public PageResult(Integer code, long count, List<T> list) {
        super();
        this.code = code;
        this.count = count;
        this.data = list;
    }

    public PageResult(Integer code, String msg, Integer page, Integer limit, long count,
        List<T> list) {
        this.code = code;
        this.msg = msg;
        this.page = page;
        this.limit = limit;
        this.count = count;
        this.data = list;
    }

    public PageResult() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
