package com.finalProject.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.finalProject.demo.model.Cart;
import com.finalProject.demo.model.Payment;
import com.finalProject.demo.model.Shipping;
import com.finalProject.demo.service.CartService;
import com.finalProject.demo.service.PaymentService;
import com.finalProject.demo.service.ShippingService;

@Controller
public class CartController {

	@Autowired
	private CartService cService;
	
	@Autowired
	private PaymentService pService;
	
	@Autowired
	private ShippingService sService;
	
	@GetMapping("/cartAll")
	public String viewCart(Cart cart,Model model) {
		List<Cart> c = cService.findAllCart();
		model.addAttribute("Cart",c);
		return "cart/cart";
	}
	
	@ModelAttribute("Payment")
	public List<Payment> viewPayment() {
		return pService.findAllPayment();
	}

	@ModelAttribute("Shipping")
	public List<Shipping> viewShipping() {
		return sService.findAllShipping();
	}
	
	
}
