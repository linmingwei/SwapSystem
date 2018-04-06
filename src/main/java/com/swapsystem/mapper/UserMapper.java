package com.swapsystem.mapper;

import com.swapsystem.pojo.RegisterForm;
import com.swapsystem.pojo.Stuff;
import com.swapsystem.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
     User findByName(String username);
     void addUser(RegisterForm form);
     User findById(int uid);
     int changeImg(User user);
     int update(User user);

     List<Stuff> byPage(Map<String, Integer> map);

}
