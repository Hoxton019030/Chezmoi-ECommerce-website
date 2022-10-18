package com.finalProject.demo.controller.back.productManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalProject.demo.model.entity.product.Products;
import com.finalProject.demo.service.product.PhotoService;
import com.finalProject.demo.service.product.ProductService;

@RestController
@RequestMapping("Back")
public class MyProductRestController {
	
	ProductService productService;
	PhotoService photoService;
	
	@Autowired
	public MyProductRestController(ProductService productService, PhotoService photoService) {
		super();
		this.productService = productService;
		this.photoService = photoService;
	}
	
	
	@GetMapping(value = "/MyProduct/all",produces = { "application/json; charset=UTF-8" })//進入畫面就會顯示全部
	public List<Products> getProducts(Model model) {	
		return productService.findAll();
	}
	
	
}
