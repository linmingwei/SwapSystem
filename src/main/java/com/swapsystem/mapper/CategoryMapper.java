package com.swapsystem.mapper;

import com.swapsystem.pojo.Category;
import com.swapsystem.pojo.Stuff;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryMapper {
    List<Category> findByPid(int pid);
    List<Stuff> findByCid(int cid);
    Category findByName(String name);
}
