package com.finalProject.demo.controller.front.pageController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.finalProject.demo.model.entity.cart.Cart;
import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.service.cart.CartService;
import com.finalProject.demo.service.member.MemberService;

@RestController
@SessionAttributes("Member")
public class NavBarController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private MemberService memberService;
	
	//找購物車有幾項商品,回傳數字顯示在navbar上
	@GetMapping(value = {"/cartQuantity"})
	public Integer viewCartQuantity(Model model) {
//		Member memberLogin = new Member();
//		memberLogin.setMemberId(1L);

		Member member = (Member) model.getAttribute("Member");
		assert member != null;
		List<Cart> findCart = cartService.findByMemberId(member);
		return findCart.size();
	}
	//現在的會員是誰
	@ModelAttribute("Member")
	public Member viewMember(HttpServletRequest request) {
		//取得memberId
		String stringId = String.valueOf(request.getAttribute("memberId"));
		Long memberId = Long.valueOf(stringId);
		return memberService.findById(memberId);
	}
	@GetMapping(value = "/showName")
	public String showName(Model model){
		Member member = (Member) model.getAttribute("Member");
		assert member!=null;
		return (member.getMemberName());
	}
}
