package com.swapsystem.controller;

import com.alibaba.fastjson.JSON;
import com.swapsystem.mapper.UserMapper;
import com.swapsystem.pojo.Page;
import com.swapsystem.pojo.RegisterForm;
import com.swapsystem.pojo.User;
import com.swapsystem.service.UserService;
import com.swapsystem.utils.ContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService service;
    /*用户登录判断*/
    @RequestMapping(value = {"/check"})
    @ResponseBody
    public Map<String,Boolean> check(HttpSession session, String username, String password) {
        Boolean result = service.checkUser(username, password);

        Map<String,Boolean> map=new HashMap<>();
        if (result) {
            User user=service.findByName(username);
            session.setAttribute("user",user);
            map.put("valide",true);
        } else {
            map.put("valide",false);
        }
        return map;
    }
    /*添加用户*/
    @RequestMapping(value = "/adduser")
    @ResponseBody
    public Map<String, Boolean> adduser(RegisterForm form) {
        service.addUser(form);
        Boolean result=service.checkUser(form.getUsername(),form.getPassword());
        Map<String, Boolean> map = new HashMap<>();
        map.put("result", result);
        return map;
    }
    /*BootstrapValidator验证用户是否存在*/
    @RequestMapping(value = "/valid")
    @ResponseBody
    public Map<String,Boolean> valid(String username){
        Boolean result=service.valid(username);
        Map<String, Boolean> map = new HashMap<>();
        map.put("valid", result);
        return map;

    }

    /*用户退出*/
    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/home.do";

    }
    /*查看他人信息*/
    @RequestMapping("/other")
    public ModelAndView other(int uid) {
        ModelAndView mv = new ModelAndView();
        User other=service.findByUid(uid);
        mv.addObject("other",other);
        mv.setViewName("other_info");
        return mv;
    }

    /*更新用户信息*/
    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Boolean> update(HttpSession session, User user) {
        Boolean result= service.update(user);
        if (result) {
            session.setAttribute("user",service.findByName(user.getUsername()));
        }
        Map<String,Boolean> map=new HashMap<>();
        map.put("result",result);
        return map;

    }
    /*用户物品分页展示*/
    @RequestMapping("/page")
    public Map<String,Page> byPage(int currPage,int uid){
        Map<String,Integer> map=new HashMap<>();
        map.put("currPage",(currPage-1)*6);
        map.put("pageSize",6);
        map.put("uid",uid);
        Page page=service.byPage(map);
        Map<String,Page> result=new HashMap<>();
        result.put("page",page);
        return result;
    }

}
