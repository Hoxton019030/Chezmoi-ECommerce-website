package com.finalProject.demo;


import com.finalProject.demo.jwtInterceptor.jwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig  implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        registry.addInterceptor(new jwtInterceptor())//"/**"為攔截全部
                .excludePathPatterns("/member/login","/member/register","")
                .addPathPatterns("/cartAll/**","/cart/**","/api/updateCart","/cart/deleteFromCart","/cartOrderDetail","/cartOrderDetail#loaded","/cartFinish","/api/postOrders")
                .addPathPatterns("/member/**")
                .addPathPatterns("/shop/addToCart","/cartQuantity");
    }
}
