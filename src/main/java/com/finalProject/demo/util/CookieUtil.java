package com.finalProject.demo.util;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Component
public class CookieUtil {


    public static Long getIdByCookie(HttpServletRequest request,String cookieName){
        return getaLong(getCookieByName(request, cookieName));

    }

    public static String getMemberNameByCookie(HttpServletRequest request,String cookieName ){
        return getaName(getCookieByName(request,cookieName));
    }

    public static Cookie getCookieByName(HttpServletRequest request, String cookieName){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies){
                if (cookieName.equals(cookie.getName())){
                    return cookie;
                }
            }
        }
        return null;
    }

    public static Long getaLong(Cookie cookieByName) {
        if (cookieByName !=null){
            String value = cookieByName.getValue();
            Claims claims = JwtUtil.verify(value);
            assert claims != null;
            String id = (String) claims.get("id");
            return Long.valueOf(id);
        }
        return null;
    }

    public static String getaName(Cookie cookieByName) {
        if (cookieByName !=null){
            String value = cookieByName.getValue();
            Claims claims = JwtUtil.verify(value);
            assert claims != null;
            return (String) claims.get("name");
        }
        return null;
    }



}
