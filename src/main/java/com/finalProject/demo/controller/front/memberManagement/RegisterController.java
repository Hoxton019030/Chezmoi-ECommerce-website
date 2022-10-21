package com.finalProject.demo.controller.front.memberManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.service.member.MemberService;

@Controller
public class RegisterController {
	
	@Autowired
	private MemberService mService;
	
	@GetMapping("/member/register")
	public String addRegister(Model model) {
		
		Member m1 = new Member();
		model.addAttribute("register",m1);
		
		return "front/member/register";
	}
	@PostMapping("/member/register")
	public String postRegister(@ModelAttribute(name="register") Member member) {
		mService.insert(member);
		
		return "front/member/register";
	}
	
}
