package com.swapsystem.controller;

import com.swapsystem.pojo.Category;
import com.swapsystem.pojo.StuffCard;
import com.swapsystem.service.StuffService;
import com.swapsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@SessionAttributes(value = {"stuffcards","categoryList","maxId"})

public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private StuffService stuffService;

    /*在显示主页之前获取数据库内容 */
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv=new ModelAndView();
        List<StuffCard> stuffCards=stuffService.getStuffCardList();
        List<Category> categoryList=stuffService.findByPid(0);
        int maxId=stuffService.maxId();
        mv.addObject("categoryList",categoryList);
        mv.addObject("stuffcards",stuffCards);
        mv.addObject("maxId",maxId);
        mv.setViewName("home");
        return mv;
    }
    /*主页*/
    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("home");
        return mv;
    }
//    @RequestMapping("/register")
//    public ModelAndView register() {
//        ModelAndView mv=new ModelAndView();
//        mv.setViewName("register");
//        return mv;
//    }
    /*注册页面*/
    @RequestMapping("/register")
    public String register() {
        return "register";
    }
    /*旧物发布页*/
    @RequestMapping("/exchange")
    public String exchange() {
        return "exchange";
    }
    /*物品详情页*/
    @RequestMapping("/itemdetails")
    public String itemdetails() {
        return "itemdetails";
    }
    /*登录页*/
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    /*物品展示页*/
    @RequestMapping("/oldstuff")
    public String oldstuff() {
        return "oldstuff";
    }
    /*他人资料页面*/
    @RequestMapping("/other_info")
    public String other_info() {
        return "other_info";
    }
    /*用户个人信息页*/
    @RequestMapping("/user")
    public String user() {
        return "user";
    }
}
