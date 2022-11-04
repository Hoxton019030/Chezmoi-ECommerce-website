package com.finalProject.demo;


import com.finalProject.demo.jwtInterceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig  implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        registry.addInterceptor(new JwtInterceptor())//"/**"為攔截全部
                .excludePathPatterns("/member/login","/member/register")
                .excludePathPatterns("/member/forgotpassword","/member/editpassword","/member/updatepassword")
                .addPathPatterns("/cartAll/**","/cart/**","/api/updateCart","/cart/deleteFromCart","/cartOrderDetail","/cartOrderDetail#loaded","/cartFinish","/api/postOrders")
                .addPathPatterns("/member/**")
                .addPathPatterns("/shop/addToCart");
    }
}
