package com.swapsystem.service;

import com.swapsystem.mapper.StuffMapper;
import com.swapsystem.mapper.UserMapper;
import com.swapsystem.pojo.Page;
import com.swapsystem.pojo.RegisterForm;
import com.swapsystem.pojo.Stuff;
import com.swapsystem.pojo.User;
import com.swapsystem.utils.ContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private Page page;
    private UserMapper userMapper;
    private StuffMapper stuffMapper;
    ApplicationContext context= ContextFactory.getContext();
    /*添加用户实现逻辑*/
    @Override
    public void addUser(RegisterForm form) {
        userMapper = context.getBean(UserMapper.class);
        userMapper.addUser(form);

    }
    /*检查用户登录*/

    @Override

    public Boolean checkUser(String username,String password) {
        userMapper = context.getBean(UserMapper.class);
        User user= userMapper.findByName(username);
        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            return true;
        }
        else if(user==null) {
            return false;
        }
        else {
            return false;
        }
    }
    /*根据用户名查找用户*/
    @Override
    public User findByName(String username) {
        User user= userMapper.findByName(username);
        return user;
    }

    /*注册验证用户是否存在*/
    @Override
    public Boolean valid(String username) {
        userMapper = context.getBean(UserMapper.class);
        User user= userMapper.findByName(username);
        if(user!=null){
            /*用户存在验证不通过*/
            return false;
        }else {
            /*用户不存在可以注册*/
            return true;
        }

    }
    /*根据用户ID查找用户*/

    @Override
    public User findByUid(int uid) {
        userMapper =context.getBean(UserMapper.class);
        return userMapper.findById(uid);

    }
    /*更新用户信息*/
    @Override
    public Boolean update(User user) {
        userMapper =context.getBean(UserMapper.class);
        int i= userMapper.update(user);
        if (i != 0) {
            return true;
        }
        else return false;
    }

    @Override
    public Page byPage(Map<String,Integer> map) {
        userMapper =context.getBean(UserMapper.class);
        stuffMapper=context.getBean(StuffMapper.class);
        List<Stuff> stuffs= userMapper.byPage(map);
        page.setStuffPage(stuffs);
        int total = stuffMapper.getTotal(map.get("uid"));
        page.setTotal(total);
        int totalPage=total/6+1;
        page.setTotalPage(totalPage);
        page.setCurrPage(map.get("currPage"));


        return page;
    }
}
