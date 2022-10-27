package com.finalProject.demo.controller.front.memberManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.service.member.MemberService;

@Controller
public class ForgetPwdController {

	@Autowired
	private MemberService mService;
	
	@GetMapping("/member/editPassword")
	public String editPassword(@RequestParam(value ="email",required = false) String email,@RequestParam(value ="phone",required = false) String phone,Model model) {
		Member member = mService.findPassword(email,phone);
		model.addAttribute("editPassword", member);
		return "front/member/forgotpassword";
		
	}

}
