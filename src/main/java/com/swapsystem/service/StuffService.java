package com.swapsystem.service;

import com.swapsystem.pojo.Category;
import com.swapsystem.pojo.Stuff;
import com.swapsystem.pojo.StuffCard;
import com.swapsystem.pojo.StuffForm;

import java.math.BigDecimal;
import java.util.List;

public interface StuffService {
    List<StuffCard> stuff2card(List<Stuff> stuffs);
    List<StuffCard> getStuffCardList();
    Stuff findById(int id);
    List<StuffCard> searchByName(String name);
    List<Category> findByPid(int pid);
    List<StuffCard> findByCid(int cid);
    Boolean addStuff(Stuff stuff);
    int maxId();
    Stuff formToStuff(StuffForm form);
}
