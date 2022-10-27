package com.finalProject.demo.controller.front.cartManagerment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.finalProject.demo.model.entity.cart.Cart;
import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.model.entity.order.Coupon;
import com.finalProject.demo.model.entity.order.OrderDetail;
import com.finalProject.demo.model.entity.order.Orders;
import com.finalProject.demo.model.entity.order.Payment;
import com.finalProject.demo.model.entity.order.Shipping;
import com.finalProject.demo.service.cart.CartService;
import com.finalProject.demo.service.member.MemberService;
import com.finalProject.demo.service.order.OrderDetailService;
import com.finalProject.demo.service.order.OrdersService;

@Lazy
@Controller
@SessionAttributes("Member")
public class AddOrderController {
	
	@Autowired
	private OrdersService oService;
	
	@Autowired
	private CartService cService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private OrderDetailService odService;
	
	//送出空白訂單表單
	@GetMapping("/cartOrderDetail")
	public String viewInputOrderDetail(Model model1,Model model2,Model model3,Model model4,Model model5){
		Member member = (Member) model1.getAttribute("Member");
		model2.addAttribute("Member",member);
		List<Cart> findCart = cService.findByMemberId(member);
		if(findCart.size()==0) {
			return "front/cart/cartNotFound";
		}
		Orders topOrder = oService.findTopOrder();
		model3.addAttribute("Orders",topOrder);
		Payment payment = topOrder.getPayment();
		model4.addAttribute("Payment",payment);
		Shipping shipping = topOrder.getShipping();
		model5.addAttribute("Shipping",shipping);
		return "front/cart/cart_orderDetail_1";
	}
	
	//送出空白訂單表單
		@GetMapping("/cartOrderDetail#loaded")
		public String viewInputOrderDetailLoad(Model model1,Model model2,Model model3,Model model4,Model model5){
			Member member = (Member) model1.getAttribute("Member");
			model2.addAttribute("Member",member);
			List<Cart> findCart = cService.findByMemberId(member);
			if(findCart.size()==0) {
				return "front/cart/cartNotFound";
			}
			Orders order = oService.findTopOrder();
			model3.addAttribute("Orders",order);
			Orders topOrder = oService.findTopOrder();
			Payment payment = topOrder.getPayment();
			model4.addAttribute("Payment",payment);
			Shipping shipping = topOrder.getShipping();
			model5.addAttribute("Shipping",shipping);
			
			return "front/cart/cart_orderDetail_1";
		}
	
	
	//傳遞前端訂單資料並insert到資料庫(Orders & OrderDetail)
	//以及刪除購物車商品
	@PostMapping("/cartFinish")
	public String newOrder(@ModelAttribute(name="Orders") Orders orders, 
			Model model) {
		
		//find member
		Member findmember = (Member) model.getAttribute("Member");
		Long memberId = findmember.getMemberId();
		Member member = memberService.findById(memberId);
		
		//add new order
		Orders topOrder = oService.findTopOrder();
		Long orderId = topOrder.getOrderId();
		Payment payment = topOrder.getPayment();
		Shipping shipping = topOrder.getShipping();
		Integer total = topOrder.getTotal();
		Coupon coupon = topOrder.getCoupon();
		orders.setOrderId(orderId);
		orders.setMember(member);
		orders.setOrderState("未付款");
		orders.setPayment(payment);
		orders.setShipping(shipping);
		orders.setTotal(total);
		orders.setCoupon(coupon);
		Orders newOrder = oService.insert(orders);
	
		//add new orderDetail
		OrderDetail orderDetail = new OrderDetail();
		List<Cart> findCart = cService.findAllCart();
		List<Cart> carts= new ArrayList<>();
		for(Cart cart:findCart) {
			orderDetail.setOrderId(newOrder.getOrderId());
			orderDetail.setProductId(cart.getProductId());
			orderDetail.setProductName(cart.getProductName());
//			orderDetail.setPhotoId(cart.getPhotoId());
			orderDetail.setProductColor(cart.getProductColor());
			orderDetail.setProductSize(cart.getProductSize());
			orderDetail.setQuantity(cart.getQuantity());
			orderDetail.setPrice(cart.getPrice());
			orderDetail.setTotal(cart.getTotal());
			odService.insert(orderDetail);
			carts.add(cart);
		}
		
		//delete all products from cart
		for(Cart cart:carts) {
			String productId = cart.getProductId();
			cService.deleteById(memberId, productId);
		}
		
		return "front/cart/cart_finish";
	}
	
	//現在的會員是誰
	@ModelAttribute("Member")
	public Member viewMember() {
		Member memberLogin = memberService.findById(2L);
		return memberLogin;
	}
	
		
	
}
