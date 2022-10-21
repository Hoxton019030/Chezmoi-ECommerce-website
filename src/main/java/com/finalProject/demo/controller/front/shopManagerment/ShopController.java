package com.finalProject.demo.controller.front.shopManagerment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalProject.demo.model.entity.product.Products;
import com.finalProject.demo.service.product.ShopService;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	@GetMapping("/shop")
	public String viewProducts(@RequestParam(name="p", defaultValue="1") Integer pageNumber, Model model) {
		Page<Products>page=shopService.findByPage(pageNumber);
		model.addAttribute("page", page);	
		return "front/shop";
	}
	
	
	
}
