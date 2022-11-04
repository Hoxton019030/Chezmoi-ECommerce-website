package com.finalProject.demo.controller.front.memberManagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class NavbarMemberShowName {

    @GetMapping(value = "/member/showName")
    public String navbarShowName(HttpServletRequest request){
    	System.out.println("request.getAttribute====="+request.getAttribute("memberName"));
        return (String) request.getAttribute("memberName");
    }
}
