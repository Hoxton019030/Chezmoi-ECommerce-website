package com.finalProject.demo.controller.front.cartManagerment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.finalProject.demo.model.dto.OrdersDto;
import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.model.entity.order.Coupon;
import com.finalProject.demo.model.entity.order.Orders;
import com.finalProject.demo.model.entity.order.Payment;
import com.finalProject.demo.model.entity.order.Shipping;
import com.finalProject.demo.service.member.MemberService;
import com.finalProject.demo.service.order.CouponService;
import com.finalProject.demo.service.order.OrdersService;
import com.finalProject.demo.service.order.PaymentService;
import com.finalProject.demo.service.order.ShippingService;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("Member")
public class SetOrderController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private ShippingService shippingService;
	
	@Autowired
	private OrdersService oService;
	
	@Autowired
	private CouponService couponService;
	
	@Autowired
	private MemberService memberService;
	
	//用ajax傳送選擇的付款方式,運送方式,總金額並insert成新訂單
		@PostMapping("/api/postOrders")
		public Orders postOrdersApi(@RequestBody OrdersDto dto,
				Model model){
			Integer paymentId = dto.getPaymentId();
			Payment payment = paymentService.findById(paymentId);
			Integer shippingId = dto.getShippingId();
			Shipping shipping = shippingService.findById(shippingId);
			Integer total = dto.getTotal();
			String couponCode = dto.getCouponCode();
			Coupon coupon = couponService.findByCouponCode(couponCode);
			Member memberLogin =(Member) model.getAttribute("Member");
			assert memberLogin != null;
			Long memberId = memberLogin.getMemberId();
			Member findMember = memberService.findById(memberId);
			Orders findTopOrder = oService.findTopOrder();
			if(findTopOrder == null) {
				Orders order = new Orders();
				order.setPayment(payment);
				order.setShipping(shipping);
				order.setTotal(total);
				order.setCoupon(coupon);
				order.setMember(findMember);
				order.setShipName("");
				order.setShipPhone("");
				order.setStoreName("");
				order.setStoreNumber("");
				oService.insert(order);
				return order;
			}
			String orderState = findTopOrder.getOrderState();
			Member member = findTopOrder.getMember();
			if(orderState!=null) {
				Orders order = new Orders();
				order.setPayment(payment);
				order.setShipping(shipping);
				order.setTotal(total);
				order.setCoupon(coupon);
				order.setMember(member);
				order.setShipName("");
				order.setShipPhone("");
				order.setStoreName("");
				order.setStoreNumber("");
				oService.insert(order);
				return order;
			}
			Long memberId2 = member.getMemberId();
			if(memberId.equals(memberId2)) {
				findTopOrder.setPayment(payment);
				findTopOrder.setShipping(shipping);
				findTopOrder.setTotal(total);
				findTopOrder.setCoupon(coupon);
				findTopOrder.setMember(findMember);
				findTopOrder.setShipName("");
				findTopOrder.setShipPhone("");
				findTopOrder.setStoreName("");
				findTopOrder.setStoreNumber("");
				oService.insert(findTopOrder);
				return findTopOrder;
			}
				Orders order = new Orders();
				order.setPayment(payment);
				order.setShipping(shipping);
				order.setTotal(total);
				order.setCoupon(coupon);
				order.setMember(findMember);
				order.setShipName("");
				order.setShipPhone("");
				order.setStoreName("");
				order.setStoreNumber("");
				oService.insert(order);
				return order;
			}
		
		
		//現在的會員是誰
		@ModelAttribute("Member")
		public Member viewMember(Model model, HttpServletRequest request) {
			//取得memberId
			String stringId = String.valueOf(request.getAttribute("memberId"));
			Long memberId = Long.valueOf(stringId);
			Member memberLogin = new Member();
			memberLogin.setMemberId(memberId);
			return memberLogin;
		}

}
