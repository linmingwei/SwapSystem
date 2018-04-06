package com.swapsystem.controller;

import com.swapsystem.pojo.*;
import com.swapsystem.service.FileService;
import com.swapsystem.service.StuffService;
import com.swapsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stuff")
public class StuffController {
    @Autowired
    private StuffService stuffService;
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;
    /*查找物品*/
    @RequestMapping(value = "/findStuff")
    public ModelAndView findStuff(int sid) {
        ModelAndView mv=new ModelAndView();
        Stuff stuff=stuffService.findById(sid);
        User user=userService.findByUid(stuff.getUid());
        mv.addObject("stuff",stuff);
        mv.addObject("user",user);
        mv.setViewName("itemdetails");
        return mv;
    }

    /*搜索物品*/
    @RequestMapping(value = "/search")
    public ModelAndView search(String searchbar) {
        ModelAndView mv=new ModelAndView();
        List<StuffCard> stuffCardList=stuffService.searchByName(searchbar);
        mv.addObject("stuffCardList",stuffCardList);
        mv.setViewName("oldstuff");
        return mv;

    }
    /*根据分类id查找物品*/
    @RequestMapping(value = "/findCid")
    public ModelAndView findByCid(int cid) {
        ModelAndView mv=new ModelAndView();
        List<StuffCard> stuffCardList=stuffService.findByCid(cid);
        mv.addObject("stuffCardList",stuffCardList);
        mv.setViewName("oldstuff");
        return mv;
    }
    /*添加物品*/
    @RequestMapping(value = "/add")
    @ResponseBody
    public Map<String,Boolean> addStuff(HttpSession session, @SessionAttribute("imgListTemp")List<Img> imgList, StuffForm form) {
        Stuff stuff=stuffService.formToStuff(form);
        Boolean result= stuffService.addStuff(stuff);
//        if (result) {
//
//
//        }
        fileService.saveImgList(imgList);
        session.removeAttribute("imgListTemp");
        Map<String,Boolean> map=new HashMap<>();
        map.put("result",result);
        return map;
    }
}
