package com.food.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 */
public class PageUtil extends LinkedHashMap<String, Object> {
	//当前页码
    private int page;
    //每页条数
    private int limit;
    //起始下标
    private int start;

    public PageUtil(int page,int limit){
        //分页参数
        this.page = page;
        this.limit = limit;
        this.start = (page - 1) * limit;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
