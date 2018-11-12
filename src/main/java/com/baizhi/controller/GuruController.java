package com.baizhi.controller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
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
@RequestMapping("guru")
public class GuruController {
    @Autowired
    private GuruService guruService;
    @RequestMapping("findAll")
    public @ResponseBody
    Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();
        //当前页数据rows:
        List<Guru> emps = guruService.findByPage(page, rows);
        //总记录数
        Long totals = guruService.findTotals();
        results.put("total",totals);
        results.put("rows",emps);
        return results;
    }
    @RequestMapping("delete")
    public @ResponseBody void delete(String id){
        guruService.delete(id);
    }
    @RequestMapping("deleteAll")
    public @ResponseBody void deleteAll(String[] byid){
        for (String s : byid) {
            guruService.delete(s);
        }
    }
    @RequestMapping("insert")
    public @ResponseBody
    Map<String,Object> insert(Guru guru, MultipartFile img, HttpServletRequest request){
        Map<String,Object> results = new HashMap<String,Object>();

        try {
            String realPath = request.getRealPath("/back/datagrid/guru/image");
            System.out.println(realPath);
            img.transferTo(new File(realPath,img.getOriginalFilename()));
            guru.setSheadpic("/back/datagrid/guru/image/"+img.getOriginalFilename());
            guruService.insert(guru);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
