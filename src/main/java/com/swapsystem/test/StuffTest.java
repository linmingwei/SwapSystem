package com.swapsystem.test;

import com.swapsystem.mapper.StuffMapper;
import com.swapsystem.mapper.UserMapper;
import com.swapsystem.pojo.Stuff;
import com.swapsystem.pojo.StuffCard;
import com.swapsystem.pojo.User;
import com.swapsystem.service.StuffService;
import com.swapsystem.service.StuffServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class StuffTest {
    @Autowired
    StuffMapper stuffMapper;
    @Autowired
    UserMapper userMapper;
//    @Autowired
//    StuffService stuffService;
//    @Autowired
//    private User user;
//    @Autowired
//    private Stuff stuff;
//    @Autowired
//    private StuffCard stuffCard;


    @Test
    public void stuffImg() {
        Stuff stuff=stuffMapper.findById(2);
        System.out.println(stuff);
    }

    @Test
    public void getCard() {
        List<Stuff> stuffs = stuffMapper.getStuffCard();
        System.out.println(stuffs);
    }

    @Test
    public void stuffcardTest() {
//        stuffMapper=context.getBean(StuffMapper.class);
//        userMapper=context.getBean(UserMapper.class);
        List<Stuff> stuffs=stuffMapper.getStuffCard();
        System.out.println(stuffs);
        List<StuffCard> stuffCards=new ArrayList<>();

//        while (stuffs.)
        for (int i = 0; i < stuffs.size(); i++) {
            Stuff stuff=new Stuff();
            User user=new User();
            StuffCard stuffCard=new StuffCard();
            stuff=stuffs.get(i);
            user=userMapper.findById(stuff.getUid());
            stuffCard.setStuffImg(stuff.getImgList().get(0).getPath());
            stuffCard.setHeadImg(user.getImgPath());
            stuffCard.setPrice(stuff.getPrice());
            stuffCard.setUsername(user.getUsername());
            stuffCard.setTitle(stuff.getName());
            stuffCard.setWilling(stuff.getWilling());
            stuffCards.add(stuffCard);

        }
        System.out.println(stuffCards);

    }

    @Test
    public void findid() {
        Stuff stuff=stuffMapper.findById(1);
        System.out.println(stuff);
    }

    @Test
    public void search() {
//        StuffService stuffService=new StuffServiceImpl();
//        List<Stuff> stuffs=stuffMapper.searchByName("相机");
//        List<StuffCard> stuffs = stuffService.searchByName("相机");
        System.out.println();
    }

    @Test
    public void add() {
        Stuff stuff=new Stuff();
        stuff.setName("test");
        stuff.setUid(1);
        stuff.setCid(1);
        stuffMapper.addStuff(stuff);
        Stuff s=stuffMapper.findByName("test");
        System.out.println(s);
    }

    @Test
    public void max() {
        int i=stuffMapper.maxId();
        System.out.println(i);
    }
}
