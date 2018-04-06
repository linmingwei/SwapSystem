package com.swapsystem.service;

import com.swapsystem.pojo.Category;

import java.util.List;

public interface CategoryService {
    /*查找二级分类根据父分类名称*/
    List<Category> findChild(String name);
}
