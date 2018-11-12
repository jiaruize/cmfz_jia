package com.baizhi.controller;

import com.baizhi.entity.Yuser;
import com.baizhi.service.YuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("yuser")
public class YuserController {
    @Autowired
    private YuserService yuserService;
    @RequestMapping("insert")
    public @ResponseBody
    Map<String,Object> insert(Yuser yuser, MultipartFile img, HttpServletRequest request){
        Map<String,Object> results = new HashMap<String,Object>();

        try {
            String realPath = request.getRealPath("/back/yuser/image");
            System.out.println(realPath);
            img.transferTo(new File(realPath,img.getOriginalFilename()));
            yuser.setPhoto("/back/yuser/image/"+img.getOriginalFilename());
            yuserService.insert(yuser);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
    @RequestMapping("update")
    public @ResponseBody
    Map<String,Object> update(Yuser yuser, MultipartFile img, HttpServletRequest request){
        Map<String,Object> results = new HashMap<String,Object>();

        try {
            String realPath = request.getRealPath("/back/yuser/image");
            System.out.println(realPath);
            img.transferTo(new File(realPath,img.getOriginalFilename()));
            yuser.setPhoto("/back/yuser/image/"+img.getOriginalFilename());
            yuserService.update(yuser);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
    @RequestMapping("queryOne")
    public @ResponseBody String queryOne(Yuser yuser){
        Yuser queryOne = yuserService.queryOne(yuser);
        if(queryOne!=null){
            return "1001";
        }else
        return "1002";
    }
}
