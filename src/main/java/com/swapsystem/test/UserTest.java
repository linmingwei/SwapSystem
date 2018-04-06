package com.swapsystem.test;

import com.swapsystem.mapper.UserMapper;
import com.swapsystem.pojo.User;
import com.swapsystem.utils.ContextFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class UserTest {
    @Autowired
    private UserMapper mapper;

    @Test
    public void checkTest() {
        String username="asdfgh";
        String password="asdfgh";
//        mapper = context.getBean(UserMapper.class);
        User user=mapper.findByName(username);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                System.out.println("success");
            }
            else
                System.out.printf("密码错误");
        }
        else
            System.out.printf("用户不存在");
    }

    @Test
    public void ut() {
        User user= ContextFactory.getContext().getBean(User.class);
        System.out.println(user);
    }
    @Test
    public void ut1() {
        User user= mapper.findById(1);
        System.out.println(user);
    }

    @Test
    public void changeImg() {
        User user=mapper.findById(9);
        System.out.println(user);
        user.setImgPath(".../img");
        int i=mapper.changeImg(user);
        System.out.println(i);
        System.out.println(user);
    }
}
