package com.finalProject.demo.controller.back.Manager;


import com.finalProject.demo.service.Manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Back")
public class backLogoutController {

    @Autowired
    private ManagerService mService;



}
