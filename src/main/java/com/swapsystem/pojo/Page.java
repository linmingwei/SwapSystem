package com.swapsystem.pojo;

import org.springframework.stereotype.Component;

import java.util.List;
@Component("page")
public class Page {
    private int currPage;
    private int pageSize;
    private int total;
    private int totalPage;
    private List<Stuff> stuffPage;

    public Page() {
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Stuff> getStuffPage() {
        return stuffPage;
    }

    public void setStuffPage(List<Stuff> stuffPage) {
        this.stuffPage = stuffPage;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currPage=" + currPage +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", totalPage=" + totalPage +
                ", stuffPage=" + stuffPage +
                '}';
    }
}
