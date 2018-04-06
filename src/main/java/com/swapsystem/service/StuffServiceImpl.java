package com.swapsystem.service;

import com.swapsystem.mapper.CategoryMapper;
import com.swapsystem.mapper.StuffMapper;
import com.swapsystem.mapper.UserMapper;
import com.swapsystem.pojo.*;
import com.swapsystem.utils.ContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StuffServiceImpl implements StuffService {
    private StuffMapper stuffMapper;
    private UserMapper userMapper;
    private CategoryMapper categoryMapper;
//    @Autowired
//    private User user;
//    @Autowired
//    private Stuff stuff;
//    @Autowired
//    private StuffCard stuffCard;
    ApplicationContext context= ContextFactory.getContext();
    public List<StuffCard> stuff2card(List<Stuff> stuffs) {
        List<StuffCard> stuffCards=new ArrayList<>();
        userMapper=context.getBean(UserMapper.class);
        for (int i = 0; i < stuffs.size(); i++) {
            Stuff stuff=new Stuff();
            User user=new User();
            StuffCard stuffCard=new StuffCard();

            stuff=stuffs.get(i);
            user=userMapper.findById(stuff.getUid());
            stuffCard.setSid(stuff.getId());
            stuffCard.setUid(stuff.getUid());
            stuffCard.setStuffImg(stuff.getImgList().get(0).getPath());
            stuffCard.setHeadImg(user.getImgPath());
            stuffCard.setPrice(stuff.getPrice());
            stuffCard.setUsername(user.getUsername());
            stuffCard.setTitle(stuff.getName());
            stuffCard.setWilling(stuff.getWilling());
            stuffCard.setLink("/user/other.do?uid="+user.getUid());
            stuffCards.add(stuffCard);

        }

        return stuffCards;

    }
    /*获取主页卡片信息*/
    @Override
    public List<StuffCard> getStuffCardList() {
        stuffMapper=context.getBean(StuffMapper.class);
        userMapper=context.getBean(UserMapper.class);
        List<Stuff> stuffs=stuffMapper.getStuffCard();
        List<StuffCard> stuffCards=stuff2card(stuffs);

        return stuffCards;
    }

    @Override
    public Stuff findById(int id) {
        stuffMapper=context.getBean(StuffMapper.class);
        Stuff stuff=stuffMapper.findById(id);
        return stuff;
    }

    @Override
    /*搜索出来的物品*/
    public List<StuffCard> searchByName(String name) {
        List<Stuff> stuffs=stuffMapper.searchByName(name);
        List<StuffCard> stuffCards=stuff2card(stuffs);
        return stuffCards;
    }

    @Override
    public List<Category> findByPid(int pid) {
        categoryMapper=context.getBean(CategoryMapper.class);
        List<Category> categoryList=categoryMapper.findByPid(0);
        for (int i = 0; i < categoryList.size(); i++) {
            List<Category> childCategoryList=categoryMapper.findByPid(categoryList.get(i).getId());
            categoryList.get(i).setCategoryList(childCategoryList);
        }
        return categoryList;
    }

    @Override
    public Boolean addStuff(Stuff stuff) {
        Boolean result;
        int i=stuffMapper.addStuff(stuff);
        if (i!=0) {
            result =true;
        }else {
            result=false;
        }

        return result;

    }

    @Override
    public List<StuffCard> findByCid(int cid) {
        List<Stuff> stuffs=categoryMapper.findByCid(cid);
        List<StuffCard> stuffCards=stuff2card(stuffs);

        return stuffCards;
    }
    /*查询物品总数*/
    @Override
    public int maxId() {
        int total=stuffMapper.maxId();
        return total;
    }

    @Override
    public Stuff formToStuff(StuffForm form) {
        Stuff stuff=new Stuff();
        stuff.setId(form.getSid());
        stuff.setCid(form.getCid());
        stuff.setUid(form.getUid());
        stuff.setName(form.getName());
        stuff.setBuyDate(form.getBuyDate());
        stuff.setDescription(form.getDescription());
        stuff.setOldness(form.getOldness());
        stuff.setOtherInfo(form.getOtherInfo());
        stuff.setOriginalPrice(form.getOriginalPrice());
        stuff.setPrice(form.getPrice());
        stuff.setWilling(form.getWilling());
        return stuff;
    }
}
