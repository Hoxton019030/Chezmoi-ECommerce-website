package com.finalProject.demo.controller.back.checkoutManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalProject.demo.model.entity.order.Coupon;
import com.finalProject.demo.service.order.CouponService;

@Controller
@RequestMapping("/Back")
public class CouponController {
	
	@Autowired
	private CouponService cService;
	
	//過來的controller
	@RequestMapping("/Coupon")
	public String addCoupon(Model model) {
		Coupon c1 = new Coupon();
		model.addAttribute("couponadd",c1);
		
		Coupon latestCode = cService.findLatest();
		model.addAttribute("latestCode",latestCode);
		return "/back/checkout/coupon";
	}
	
	//送出的controller
	@RequestMapping("/addCoupon")
	public String postCoupon(HttpServletRequest request, Model model) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		
		String couponName = request.getParameter("couponName");
		String couponCode = request.getParameter("couponCode");
		Integer discountPrice = Integer.parseInt(request.getParameter("discountPrice"));
		Integer minimum = Integer.parseInt(request.getParameter("minimum"));
		Date dateStart = formatter.parse(request.getParameter("dateStart"));
		Date dateEnd = formatter.parse(request.getParameter("dateEnd"));
		
		Coupon c1 = new Coupon();
		c1.setCouponName(couponName);
		c1.setCouponCode(couponCode);
		c1.setDiscountPrice(discountPrice);
		c1.setMinimum(minimum);
		c1.setDateStart(dateStart);
		c1.setDateEnd(dateEnd);
		cService.insert(c1);
		return "redirect:/Back/Coupon/view";
	}
		
	@RequestMapping("/Coupon/view")
	public String viewCoupon(@RequestParam(name = "p",defaultValue = "1") Integer pageNumber,Model model) {
		Page<Coupon> page = cService.findByPage(pageNumber);
		model.addAttribute("page",page);
		return "/back/checkout/coupon";
	}
	
	
}
