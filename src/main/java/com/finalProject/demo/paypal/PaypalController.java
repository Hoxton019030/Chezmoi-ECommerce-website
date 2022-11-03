package com.finalProject.demo.paypal;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.model.entity.order.OrderDetail;
import com.finalProject.demo.model.entity.order.Orders;
import com.finalProject.demo.service.member.MemberService;
import com.finalProject.demo.service.order.OrderDetailService;
import com.finalProject.demo.service.order.OrdersService;
import com.paypal.api.payments.Links;
import com.paypal.base.rest.PayPalRESTException;


@Controller
public class PaypalController {

	@Autowired
	PaypalService paypalService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	public static final String SUCCESS_URL = "cart/paypal/success";
	public static final String CANCEL_URL = "cart/paypal/cancel";

	//顯示paypal頁面
	@GetMapping("/cart/paypal")
	public String view(Model model) {
		model.addAttribute("order",new Order());
		Member member = memberService.findById(1L);
		List<Orders> findOrders = ordersService.findOrderByMember(member);
		
		return "front/cart/cart_paypal";
	}
	
	//送出paypal表單
	@PostMapping("/cart/paypal")
	public String payment(@ModelAttribute(name = "order") Order order) {
		 try {
			com.paypal.api.payments.Payment payment= paypalService.createPayment(order.getPrice() , order.getCurrency(), order.getMethod(), order.getIntent(), order.getDescription(), 
					"http://localhost:8080/"+CANCEL_URL, "http://localhost:8080/"+SUCCESS_URL);
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
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            com.paypal.api.payments.Payment payment = paypalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "front/cart/success";
            }
        } catch (PayPalRESTException e) {
         System.out.println(e.getMessage());
        }
        return "redirect:/cart/paypal";
    }
    
}
