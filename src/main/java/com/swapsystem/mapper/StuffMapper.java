package com.swapsystem.mapper;

import com.swapsystem.pojo.Stuff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuffMapper {
    Stuff findByUid(int uid);
    Stuff findById(int id);
    List<Stuff> getStuffCard();
    List<Stuff> searchByName(String name);
    Stuff findByCid(int cid);
    int addStuff(Stuff stuff);
    Stuff findByName(String name);
    int maxId();
    int getTotal(int uid);

}
