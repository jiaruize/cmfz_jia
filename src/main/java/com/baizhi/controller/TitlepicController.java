package com.baizhi.controller;

import com.baizhi.entity.Titlepic;
import com.baizhi.service.TitlepicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("titlepic")
public class TitlepicController {
    @Autowired
    private TitlepicService titlepicService;
    @RequestMapping("findAll")
    public @ResponseBody
    Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();
        //当前页数据rows:
        List<Titlepic> emps = titlepicService.findByPage(page, rows);
        //总记录数
        Long totals = titlepicService.findTotals();
        results.put("total",totals);
        results.put("rows",emps);
        return results;
    }
    @RequestMapping("delete")
    public @ResponseBody void delete(String id){
        titlepicService.delete(id);
    }
    @RequestMapping("deleteAll")
    public @ResponseBody void delete(String[] byid){
        for (String s : byid) {
            titlepicService.delete(s);
        }
    }
    @RequestMapping("insert")
    public @ResponseBody
    Map<String,Object> insert(Titlepic titlepic, MultipartFile img, HttpServletRequest request){
        Map<String,Object> results = new HashMap<String,Object>();

        try {
            String realPath = request.getRealPath("/back/datagrid/titlepic/image");
            System.out.println(realPath);
            img.transferTo(new File(realPath,img.getOriginalFilename()));
            titlepic.setThumbnail("/back/datagrid/titlepic/image/"+img.getOriginalFilename());
            titlepicService.insert(titlepic);
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
    Map<String,Object> update(Titlepic titlepic, MultipartFile img, HttpServletRequest request){
        Map<String,Object> results = new HashMap<String,Object>();

        try {
            String realPath = request.getRealPath("/back/datagrid/titlepic/image");
            System.out.println(realPath);
            img.transferTo(new File(realPath,img.getOriginalFilename()));
            titlepic.setThumbnail("/back/datagrid/titlepic/image/"+img.getOriginalFilename());
            titlepicService.update(titlepic);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
    @RequestMapping("queryOne")
    public @ResponseBody Titlepic queryOne(Titlepic titlepic){
        Titlepic queryOne = titlepicService.queryOne(titlepic);
        return queryOne;
    }
}
