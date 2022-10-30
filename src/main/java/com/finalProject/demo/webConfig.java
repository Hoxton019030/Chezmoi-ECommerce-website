package com.finalProject.demo;


import com.finalProject.demo.jwtInterceptor.jwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig  implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        registry.addInterceptor(new jwtInterceptor())
                .addPathPatterns("/cartAll/**");//"/**"為攔截全部
    }
}
