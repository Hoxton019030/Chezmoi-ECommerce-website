package com.finalProject.demo.jwtInterceptor;

import com.finalProject.demo.jwt.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;


public class jwtInterceptor implements HandlerInterceptor {

    //請求在進入controller前執行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //從http請求頭獲取token
        String token;
        Cookie[] cookies = request.getCookies();
        if (cookies.length>0){
            for (Cookie cookie: cookies){
                if (!cookie.getName().equals("token")){
//                	response.sendRedirect(request.getContextPath()+"/member/login");
                     return false;
                    }
                if(cookie.getName().equals("token")) {
                	token = cookie.getValue();
                    System.out.println(token);
                    Claims claims = JwtUtil.verify(token);
                    assert claims != null;
                    Integer memberId = (Integer) claims.get("id");
//                    Long memberId =(Long) claims.get("id");
                    System.out.println("memberId===="+memberId);
                    if (memberId!=null){
                        request.setAttribute("id",memberId);
                    }	
                }
                
            }
        }return  true;


//        if(cookies.length>0 && cookies.){
////            if (header.startsWith("Bearer")){
////                String token = header.substring(7);
////                Claims claims = JwtUtil.verify(token);
////                assert claims != null;
////                String name =(String) claims.get("name");
////                System.out.println("username==="+name);
////                if (name!=null){
////                    request.setAttribute("token",token);
////                }
////            } return true;
//        }else {
//            return  false;
//        }

    }
    //controller之後執行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
