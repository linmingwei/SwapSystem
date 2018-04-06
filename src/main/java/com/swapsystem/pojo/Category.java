package com.swapsystem.pojo;

import org.springframework.stereotype.Component;

import java.util.List;
@Component("category")
/*用于物品分类的类*/
public class Category {
    private int id;
    private String name;
    private int pid;
    private List<Stuff> stuffList=null;
    private List<Category> categoryList=null;

    public Category() {
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public List<Stuff> getStuffList() {
        return stuffList;
    }

    public void setStuffList(List<Stuff> stuffList) {
        this.stuffList = stuffList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", stuffList=" + stuffList +
                ", categoryList=" + categoryList +
                '}';
    }
}
