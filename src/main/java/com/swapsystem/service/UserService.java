package com.swapsystem.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.swapsystem.pojo.Page;
import com.swapsystem.pojo.RegisterForm;
import com.swapsystem.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface UserService {
    public void addUser(RegisterForm form);
    public Boolean checkUser(String username,String password);
    Boolean valid(String username);
    User findByName(String username);
    User findByUid(int uid);
    Boolean update(User user);
    Page byPage(Map<String,Integer> map);

}
