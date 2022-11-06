package com.finalProject.demo.controller.back.Manager;


import com.finalProject.demo.model.entity.manager.Manager;
import com.finalProject.demo.service.Manager.ManagerService;
import com.finalProject.demo.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("Back")
public class managerListController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("manager")
    public String viewMember(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
        Page<Manager> managers = managerService.findByPage(pageNumber);

        model.addAttribute("page", managers);

        return "back/manager/managerList";
    }

    @GetMapping("manager/delete/{id}")
    public String delete(@PathVariable("id")Long id, HttpServletRequest request, HttpServletResponse response){
        managerService.delete(id);
        String cookieName ="tokenM";
        CookieUtil.removeManagerCookieToken(request, response, cookieName);
        return"redirect:/Back/manager";
    }

//    @GetMapping("manager/edit/{id}")
//    public String edit(@PathVariable("id")Long id,Model model){
//        Manager manager = managerService.findById(id);
//        model.addAttribute("manager",manager);
//        return "back/manager/editManager";
//    }


}
