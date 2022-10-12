package com.finalProject.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.finalProject.demo.model.Orders;
import com.finalProject.demo.service.OrdersService;

@Controller
public class CarOrderDetailController {
	
	@Autowired
	private OrdersService oService;

	@GetMapping("/cartOrderDetail")
	public String viewInputOrderDetail(Model model){
		
		Orders o = new Orders();
		
		model.addAttribute("Orders",o);
		
		return "cart/cart_orderDetail_1";
	}
	
	@PostMapping("/cartFinish")
	public String PostOrders(@ModelAttribute(name="Orders") Orders orders, Model model) {
		oService.insert(orders);
		
		return "cart/cart_finish";
	}
}
