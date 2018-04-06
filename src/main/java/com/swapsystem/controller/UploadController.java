package com.swapsystem.controller;

import com.swapsystem.pojo.Img;
import com.swapsystem.pojo.User;
import com.swapsystem.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    @Autowired
    FileService fileService;
    /*上传物品图片*/
    @RequestMapping("/stuffImg")
    @ResponseBody
    public Map<String, Integer> stuffImg(HttpSession session, MultipartFile file,int sid) {
        Map<String,Integer> map=fileService.uploadStuffImg(file,sid);
        if (map.get("code") == 200) {
            if (session.getAttribute("imgListTemp") == null) {
                List<Img> imgListTemp=new ArrayList<>();
                Img img=new Img();
                img.setPath("../img/upload/"+file.getOriginalFilename());
                img.setSid(sid);
                imgListTemp.add(img);
                session.setAttribute("imgListTemp",imgListTemp);

            }
            else {
                List<Img> imgListTemp = (List<Img>) session.getAttribute("imgListTemp");
                Img img=new Img();
                img.setPath("../img/upload/"+file.getOriginalFilename());
                img.setSid(sid);
                imgListTemp.add(img);
                session.setAttribute("imgListTemp",imgListTemp);

            }
//            List<Img> imgList=new ArrayList<>();
//            session.setAttribute("imgListTemp",imgList);
//
//           List<Img> imgListTemp= fileService.saveStuffImg(file,sid);
//            session.setAttribute("imgListTemp",imgListTemp);
        }

        return map;
    }

    /*上传用户头像*/
    @RequestMapping("/userImg")
    @ResponseBody
    public Map<String,Boolean> userImg(@SessionAttribute("user") User user,MultipartFile file) {
        Map<String,Boolean> map=new HashMap<>();
        Boolean result=fileService.addUserImg(user,file);
        map.put("result",result);
        return map;
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public ModelAndView test(MultipartFile file) {
//        MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest)request;
//        MultipartFile file = multipartRequest.getFile("file");
        ModelAndView mv=new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        String fileName=file.getOriginalFilename();
//        String path="e:/actionSpring/";
        File dest=new File( fileName);
        try {
            file.transferTo(dest);
            mv.addObject("success",true);
            mv.addObject("msg","文件上传成功");
        } catch (IOException e) {
            mv.addObject("success",false);
            mv.addObject("msg","文件上传失败");
            e.printStackTrace();
        }


        return mv;
    }
}
