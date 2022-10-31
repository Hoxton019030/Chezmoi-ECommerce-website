package com.finalProject.demo.controller.front.pageController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.finalProject.demo.model.entity.cart.Cart;
import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.service.cart.CartService;

@RestController
@SessionAttributes("Member")
public class NavBarController {

	@Autowired
	private CartService cartService;
	
	@GetMapping(value = {"/cartQuantity"})
	public Integer viewCartQuantity(Model model) {
		Member memberLogin = new Member();
		memberLogin.setMemberId(2L);
		List<Cart> findCart = cartService.findByMemberId(memberLogin);
		int cartQuantity = findCart.size();
		return cartQuantity;
	}
}
