package com.finalProject.demo.controller.front.cartManagerment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.finalProject.demo.model.dto.OrdersDto;
import com.finalProject.demo.model.entity.cart.Cart;
import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.model.entity.order.OrderDetail;
import com.finalProject.demo.model.entity.order.Orders;
import com.finalProject.demo.model.entity.order.Payment;
import com.finalProject.demo.model.entity.order.Shipping;
import com.finalProject.demo.service.cart.CartService;
import com.finalProject.demo.service.order.OrderDetailService;
import com.finalProject.demo.service.order.OrdersService;
import com.finalProject.demo.service.order.PaymentService;
import com.finalProject.demo.service.order.ShippingService;

@Controller
public class AddOrderController {
	
	@Autowired
	private OrdersService oService;
	
	@Autowired
	private CartService cService;
	
	
	@Autowired
	private OrderDetailService odService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private ShippingService shippingService;

	//送出空白訂單表單
	@GetMapping("/cartOrderDetail")
	public String viewInputOrderDetail(Model model){
		Orders order = oService.findTopOrder();
		model.addAttribute("Orders",order);
		return "front/cart/cart_orderDetail_1";
	}
	
	@PostMapping("/api/postOrders")
	public void postOrdersApi(@RequestBody OrdersDto dto){
		Integer paymentId = dto.getPaymentId();
		Payment payment = paymentService.findById(paymentId);
		Integer shippingId = dto.getShippingId();
		Shipping shipping = shippingService.findById(shippingId);
		Integer total = dto.getTotal();
		Orders order = new Orders();
		order.setPayment(payment);
		order.setShipping(shipping);
		order.setTotal(total);
		order.setShipName("");
		order.setShipPhone("");
		order.setStoreName("");
		order.setStoreNumber("");
		oService.insert(order);
		return;
	}
	
	//傳遞前端訂單資料並insert到資料庫(Orders & OrderDetail)
	//以及刪除購物車商品
	@PostMapping("/cartFinish")
	public String newOrder(@ModelAttribute(name="Orders") Orders orders, 
			Model model) {
		
		//find member
		Member member = (Member) model.getAttribute("Member");
		Long memberId = member.getMemberId();
		
		//add new order
//		Orders topOrder = oService.findTopOrder();
		orders.setMember(member);
		orders.setOrderState("未付款");
		
		//設定總金額還沒處理好!!!
		orders.setTotal(10000);
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
	public Member viewMember(Model model) {
		Member memberLogin = new Member();
		memberLogin.setMemberId(2L);
		return memberLogin;
	}
	
	
	
	
	
	
}
