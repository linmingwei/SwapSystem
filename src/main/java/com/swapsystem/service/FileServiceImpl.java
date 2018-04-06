package com.swapsystem.service;

import com.swapsystem.mapper.ImgMapper;
import com.swapsystem.mapper.UserMapper;
import com.swapsystem.pojo.Img;
import com.swapsystem.pojo.User;
import com.swapsystem.utils.ContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class FileServiceImpl implements FileService {

    private ImgMapper imgMapper;
    private UserMapper userMapper;
    ApplicationContext context=ContextFactory.getContext();
    @Override
    public Map<String,Integer> uploadStuffImg(MultipartFile file, int sid) {
//        imgMapper=context.getBean(ImgMapper.class);
//        Img img=new Img();
        String originalFilename=file.getOriginalFilename();
//        img.setPath("../img/upload/"+originalFilename);


//        String path="e:/myGitHub/SwapSystem/web/img/upload/";
//        File files=new
//        String fileName= UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
        File upload=new File(originalFilename);
        Map<String,Integer> map=new HashMap<>();
        try {
            file.transferTo(upload);
//            imgList.add(img);
//            imgMapper.addImg(img);
            map.put("code",200);

        } catch (IOException e) {
            map.put("code",404);
            e.printStackTrace();

        }
        return map;

    }

    @Override
    public List<Img> saveStuffImg(MultipartFile file, int sid) {
        imgMapper=context.getBean(ImgMapper.class);
        Img img=new Img();
        img.setPath("../img/upload/"+file.getOriginalFilename());
        img.setSid(sid);
        List<Img> imgList=new ArrayList<>();
        imgList.add(img);
        return imgList;
    }

    @Override
    /*添加用户头像*/
    public Boolean addUserImg(User user, MultipartFile file) {
        userMapper=context.getBean(UserMapper.class);
        String fileName=file.getOriginalFilename();
        String path="../img/upload/";
        File userImg=new File(fileName);
        try {
            file.transferTo(userImg);
            user.setImgPath(path+fileName);
            userMapper.changeImg(user);
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
//        int i=userMapper.changeImg(user);
//        if (i != 0) {
//            return true;
//        }else {
//            return false;
//        }


    }

    @Override
    public void saveImgList(List<Img> imgList) {
        imgMapper=context.getBean(ImgMapper.class);
        for (Img img :
                imgList) {
            imgMapper.addImg(img);
        }
    }
}
