package com.swapsystem.service;

import com.swapsystem.mapper.CategoryMapper;
import com.swapsystem.pojo.Category;
import com.swapsystem.utils.ContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findChild(String name) {
        categoryMapper= ContextFactory.getContext().getBean(CategoryMapper.class);
        Category parent=categoryMapper.findByName(name);
        List<Category> childs=categoryMapper.findByPid(parent.getId());
        return childs;
    }
}
