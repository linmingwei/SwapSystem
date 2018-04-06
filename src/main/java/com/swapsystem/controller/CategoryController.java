package com.swapsystem.controller;

import com.swapsystem.pojo.Category;
import com.swapsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    /*查找二级分类*/
    @RequestMapping("/findChild")
    @ResponseBody
    public Map<String,List<Category>> findChild(String pname) {
        List<Category> childs=categoryService.findChild(pname);
        Map<String,List<Category>> map=new HashMap<>();
        map.put("childs",childs);
        return map;

    }
    @RequestMapping("/findChild1")
    public ModelAndView findChild() {
        ModelAndView mv=new ModelAndView();
        List<Category> childs=categoryService.findChild("服装");
        Map<String,List<Category>> map=new HashMap<>();
        map.put("childs",childs);
        mv.addObject("childs",childs);
        mv.setView(new MappingJackson2JsonView());
        return mv;

    }

    /*物品图片上传*/
//    @RequestMapping("/upload")
//    public String addImg() {
//        return null;
//    }
}
