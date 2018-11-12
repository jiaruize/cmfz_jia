package com.baizhi.controller;


import com.baizhi.entity.Guser;
import com.baizhi.service.GuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("guser")
public class GuserController {
    @Autowired
    private GuserService guserService;

    @RequestMapping("login")
    public String login(Guser guser, HttpServletRequest request,String enCode){
        Guser findOne = guserService.findOne(guser);
        if(findOne==null){
            return "back/admin/login";
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("findOne",findOne);
            session.setAttribute("login","login");
            String validationCode = (String)session.getAttribute("validationCode");
            if(validationCode.equals(enCode)){
                return "redirect:/back/main/main.jsp";
            }
            else{
                return "back/admin/login";
            }
        }
        }
    @RequestMapping("update")
    public @ResponseBody
    Map<String,Object> update(Guser guser, String ypassword){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            Guser querypwd = guserService.querypwd(ypassword);
            if(querypwd!=null) {
                guserService.update(guser);
                results.put("scc", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            results.put("scc",false);
            results.put("message",e.getMessage());
        }
        return results;
    }
    @RequestMapping("out")
    public  String out(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/back/admin/login.jsp";
    }

}
