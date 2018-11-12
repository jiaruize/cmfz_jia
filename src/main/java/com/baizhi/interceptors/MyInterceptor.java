package com.baizhi.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object method) throws Exception {
        String login =(String) request.getSession().getAttribute("login");
        if(login==null){
            response.sendRedirect(request.getContextPath()+"/back/admin/login.jsp");
            System.out.println("as");
            return false;
        }
        System.out.println("assssssss");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object method, ModelAndView mv) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object method, Exception exce) throws Exception {

    }
}
