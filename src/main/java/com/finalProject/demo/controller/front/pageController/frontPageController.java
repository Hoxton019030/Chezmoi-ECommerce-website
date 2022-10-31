package com.finalProject.demo.controller.front.pageController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.finalProject.demo.model.entity.order.OrderDetail;
import com.finalProject.demo.service.product.ShopService;
@Controller
public class frontPageController {
//	@GetMapping("/shop")
//	public String shopall() {
//		return "front/shop";
//	}
	@Autowired
	private ShopService shopService;
	@GetMapping("/")
	public String index(Model model) {
		List<Object[]> findBestProduct = shopService.findBestProduct();
		model.addAttribute("bestProduct",findBestProduct);
		return "front/index";
	}
	
	@GetMapping("notice")
	public String notice() {
		return "front/notice";
	}
	
	@GetMapping("contact")
	public String contact() {
		return "front/contact";
	}
	
	@GetMapping("product/detail")
	public String productDetail() {
		return "front/productDetail";
	}

}
