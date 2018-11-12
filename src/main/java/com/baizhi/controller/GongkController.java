package com.baizhi.controller;

import com.baizhi.entity.Gongk;
import com.baizhi.service.GongkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("gongk")
public class GongkController {
    @Autowired
    private GongkService gongkService;
    @RequestMapping("findAll")
    public @ResponseBody
    Map<String,Object> findAll(Integer page, Integer rows){
        Map<String,Object> results = new HashMap<String,Object>();
        //当前页数据rows:
        List<Gongk> emps = gongkService.queryByPage(page, rows);
        //总记录数
        Long totals = gongkService.queryTotals();
        results.put("total",totals);
        results.put("rows",emps);
        return results;
    }
    @RequestMapping("delete")
    public @ResponseBody void delete(String id){
        gongkService.delete(id);
    }
    @RequestMapping("insert")
    public @ResponseBody
    Map<String,Object> insert(Gongk gongk, HttpServletRequest request){
        Map<String,Object> results = new HashMap<String,Object>();

        try {
            gongkService.insert(gongk);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
}
