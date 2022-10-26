package com.finalProject.demo.controller.front.pageController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.model.entity.order.Orders;
import com.finalProject.demo.service.order.OrdersService;

@Controller
@SessionAttributes("Member")
public class OrderController {

	@Autowired
	private  OrdersService ordersService;
	
	//顯示所有訂單
	@GetMapping("/member/order")
	public String viewAllOrder(Model model1,Model model2) {
		Member member=(Member) model1.getAttribute("Member");
		Long memberId1 = member.getMemberId();
		List<Orders> allOrders = ordersService.findAllOrders();
		List<Orders> orders = new ArrayList<>();
		for(Orders order:allOrders) {
			Member member2 = order.getMember();
			Long memberId2 = member2.getMemberId();
			if(memberId1 == memberId2) {
				orders.add(order);
			}
		}
		model2.addAttribute("Orders",orders);
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
