package com.finalProject.demo.controller.front.pageController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.finalProject.demo.model.entity.cart.Cart;
import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.model.entity.order.Payment;
import com.finalProject.demo.model.entity.order.Shipping;
import com.finalProject.demo.service.cart.CartService;
import com.finalProject.demo.service.order.PaymentService;
import com.finalProject.demo.service.order.ShippingService;

@Controller
@SessionAttributes("Member")
public class CartController {

	@Autowired
	private CartService cService;
	
	@Autowired
	private PaymentService pService;
	
	@Autowired
	private ShippingService sService;
	
	
	//顯示所有購物車商品
	@GetMapping("/cartAll")
	public String viewAllCart(Model model) {
		Member memberLogin = new Member();
		memberLogin.setMemberId(2L);
		Long memberId = memberLogin.getMemberId();
		List<Cart> cartAll = cService.findAllCart();
		List<Cart> carts = new ArrayList<>();
		for(Cart cart : cartAll) {
			Long findMember = cart.getMemberId();
			if(memberId == findMember) {
				carts.add(cart);
			}
		}
		model.addAttribute("Carts",carts);
		return "front/cart/cart";
	}
	
	
	//現在的會員是誰
//	@ModelAttribute("Member")
//	public Member viewMember(Model model) {
//		Member memberLogin = new Member();
//		memberLogin.setMemberId(1L);
//		return memberLogin;
//	}
	
	//找所有付款方式
	@ModelAttribute("Payment")
	public List<Payment> viewPayment() {
		return pService.findAllPayment();
	}

	//找所有運送方式
	@ModelAttribute("Shipping")
	public List<Shipping> viewShipping() {
		return sService.findAllShipping();
	}
	//顯示購物車完成頁面
	@GetMapping("/cartFinish")
	public String viewCartFinish() {
		return "front/cart/cart_finish";
	}
	
	
}
