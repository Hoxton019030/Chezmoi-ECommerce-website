package com.finalProject.demo.jwtInterceptor;

import com.finalProject.demo.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class jwtInterceptor implements HandlerInterceptor {


    //請求在進入controller前執行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //從http請求頭獲取token
        String token;
        Cookie[] cookies = request.getCookies();
        if (cookies.length>0){
            Cookie tokenByCookie = getCookieByName(request, "token");
            if (tokenByCookie!=null){
                String tokenValue = tokenByCookie.getValue();
                try {
                    Claims claims = JwtUtil.verify(tokenValue);
                    assert claims != null;
                    Integer memberId = (Integer) claims.get("id");
                    String name = (String) claims.get("name");
//                    System.out.println("memberId===="+memberId);//之後member應該要轉成Long類別
                    if (memberId != 0){
                        request.setAttribute("memberId",memberId);
                        request.setAttribute("memberName",name);
                        return true;
                    }
                }catch (JwtException jwtException){
                    //當verify發現token已經過期時，會丟出JwtException，在這裡做處理
                    //跳轉到登入畫面
                    //進入到登入並發送時會404
                    response.sendRedirect(request.getContextPath()+"/member/login");
                    return false;
                }
            }else {

                String requestURI = request.getRequestURI();
//                request.setAttribute("uri",requestURI);
//                request.getRequestDispatcher("/member/login").forward(request,response);
                response.sendRedirect(request.getContextPath()+"/member/login");
                return false;
            }

        }
        return true;

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

    //取得特定cookie的值
    public static Cookie getCookieByName(HttpServletRequest request,String name){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies){
                if (name.equals(cookie.getName())){
                    return cookie;
                }
            }
        }
        return null;
    }
}
