package com.finalProject.demo.controller.front.pageController;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.model.entity.order.Orders;
import com.finalProject.demo.model.entity.order.Payment;
import com.finalProject.demo.model.entity.order.Shipping;
import com.finalProject.demo.service.order.OrdersService;

@Controller
@SessionAttributes("Member")
public class OrderController {

	@Autowired
	private  OrdersService ordersService;
	
	//顯示所有訂單
	@GetMapping("/member/order")
	public String viewAllOrder(Model model1,Model model2,Model model3,Model model4) {
		Member member=(Member) model1.getAttribute("Member");
		List<Orders> orders = ordersService.findOrderByMember(member);
		model2.addAttribute("Orders",orders);
		List<Shipping> shippings = new ArrayList<>();
		List<Payment> payments = new ArrayList<>();
		for(Orders order:orders) {
			Shipping shipping = order.getShipping();
			shippings.add(shipping);
			Payment payment = order.getPayment();
			payments.add(payment);
		}
		model3.addAttribute("Shipping",shippings);
		model4.addAttribute("Payment",payments);
		return "front/member/order";
	}
	
	
	
	//現在的會員是誰
	@ModelAttribute("Member")
	public Member viewMember(Model model) {
		Member memberLogin = new Member();
		memberLogin.setMemberId(2L);
		return memberLogin;
	}
}
