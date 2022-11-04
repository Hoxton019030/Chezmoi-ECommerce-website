package com.finalProject.demo.paypal;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.model.entity.order.OrderDetail;
import com.finalProject.demo.model.entity.order.Orders;
import com.finalProject.demo.service.member.MemberService;
import com.finalProject.demo.service.order.OrderDetailService;
import com.finalProject.demo.service.order.OrdersService;
import com.paypal.api.payments.Links;
import com.paypal.base.rest.PayPalRESTException;


@Controller
@SessionAttributes("Member")
public class PaypalController {

	@Autowired
	PaypalService paypalService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private OrdersService ordersService;
	
	public static final String SUCCESS_URL = "cart/paypal/success";
	public static final String CANCEL_URL = "cart/paypal/cancel";

	//顯示paypal頁面
	@GetMapping("/cart/paypal")
	public String view(Model model) {
		//送出空白表單
		model.addAttribute("order",new Order());
		//找orderDetail
//		Member member = memberService.findById(1L);
		Member member =(Member) model.getAttribute("Member");
		List<Orders> findOrders = ordersService.findOrderByMember(member);
		int last = findOrders.size()-1;
		Orders order = findOrders.get(last);
		String orderState = order.getOrderState();
		String state = "已付款";
		if(orderState.equals(state)) {
			return "front/cart/cancel";
		}
		model.addAttribute("Order",order);
		Long orderId = order.getOrderId();
		List<OrderDetail> findOrderDetail = ordersService.findOrderDetail(orderId);
		model.addAttribute("OrderDetail",findOrderDetail);
		return "front/cart/cart_paypal";
	}
	
	//送出paypal表單
	@PostMapping("/cart/paypal")
	public String payment(@ModelAttribute(name = "order") Order order) {
		 try {
			com.paypal.api.payments.Payment payment= paypalService.createPayment(order.getPrice() , order.getCurrency(), order.getMethod(), order.getIntent(), order.getDescription(), 
					"http://localhost:8080/Chezmoi/"+CANCEL_URL, "http://localhost:8080/Chezmoi/"+SUCCESS_URL);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					return "redirect:"+link.getHref();
				}
			}
		 } catch (PayPalRESTException e) {

			e.printStackTrace();
		}
		 return "redirect:/cart/paypal";
	}
	
	//paypal付款失敗頁面
	@GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "front/cart/cancel";
    }

	//paypal付款成功頁面
    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, 
    						 @RequestParam("PayerID") String payerId,
    						 Model model) {
        try {
            com.paypal.api.payments.Payment payment = paypalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
            	Member member =(Member) model.getAttribute("Member");
        		List<Orders> findOrders = ordersService.findOrderByMember(member);
        		int last = findOrders.size()-1;
        		Orders order = findOrders.get(last);
        		order.setOrderState("已付款");
        		ordersService.insert(order);
                return "front/cart/success";
            }
        } catch (PayPalRESTException e) {
         System.out.println(e.getMessage());
        }
        return "redirect:/cart/paypal";
    }
    
  //現在的會員是誰
  	@ModelAttribute("Member")
  	public Member viewMember(HttpServletRequest request) {
  		//取得memberId
  		String stringId = String.valueOf(request.getAttribute("memberId"));
  		Long memberId = Long.valueOf(stringId);
  		Member memberLogin = memberService.findById(memberId);
  		return memberLogin;
  	}
    
}
