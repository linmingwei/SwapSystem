package com.swapsystem.test;

import com.swapsystem.mapper.CategoryMapper;
import com.swapsystem.pojo.Category;
import com.swapsystem.pojo.Stuff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class CategoryTest {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void ct() {
        List<Category> categoryList=categoryMapper.findByPid(0);
        for (int i = 0; i < categoryList.size(); i++) {
            List<Category> childCategoryList=new ArrayList<>();
            childCategoryList=categoryMapper.findByPid(categoryList.get(i).getId());
            categoryList.get(i).setCategoryList(childCategoryList);
        }
        System.out.println(categoryList.get(0));

    }

    @Test
    public void ct2() {
        List<Stuff> stuffList=categoryMapper.findByCid(13);
        System.out.println(stuffList);

    }
    @Test
    public void findChild() {
        Category category=categoryMapper.findByName("服装");
        List<Category> categoryList=categoryMapper.findByPid(category.getId());
        System.out.println(categoryList);
    }

}
