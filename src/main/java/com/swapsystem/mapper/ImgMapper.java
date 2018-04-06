package com.swapsystem.mapper;

import com.swapsystem.pojo.Img;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgMapper {
    Img findBySid(int sid);
    int addImg(Img img);
}
