package com.swapsystem.test;

import com.swapsystem.mapper.UserMapper;
import com.swapsystem.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class SpringTest {
    @Autowired
    private UserMapper mapper;
    @Test
    public void test() {
        User user = mapper.findByName("asdfgh");
        System.out.println(user);
    }

    @Test
    public void testHeadImg() {
        String id="/user/other.do?uid="+7;
        System.out.println(id);
    }

}
