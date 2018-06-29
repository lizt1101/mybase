package com.lzt;

import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :LIZITAO
 * @Description:
 * @Date :Created in 16:05 2018/4/16
 * @Modified By:
 */
public class PageDto<T>{
    private Integer pageNum;

    private Long allCount;

    private Integer totalPage;

    private Integer pageSize;

    private List<T> list;

    public PageDto(){
        this.pageNum = 1;
        this.allCount = 0L;
        this.totalPage = 0;
        this.pageSize = 10;
        this.list=new ArrayList<>();
    }

    public PageDto(PageInfo page, List<T> list) {
        this.allCount = page.getTotal();
        this.pageNum = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.totalPage = page.getPages();
        this.list = list;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Long getAllCount() {
        return allCount;
    }

    public void setAllCount(Long allCount) {
        this.allCount = allCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}

