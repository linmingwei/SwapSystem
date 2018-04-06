package com.swapsystem.service;

import com.swapsystem.pojo.Img;
import com.swapsystem.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface FileService {
    Map<String,Integer> uploadStuffImg(MultipartFile file,int sid);
    List<Img> saveStuffImg(MultipartFile file, int sid);
    void saveImgList(List<Img> imgList);
    Boolean addUserImg(User user,MultipartFile file);


//    void addImg(Img img);
}
