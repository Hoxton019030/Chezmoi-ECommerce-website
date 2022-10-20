package com.finalProject.demo.controller.back.productManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalProject.demo.model.entity.product.Products;
import com.finalProject.demo.service.product.PhotoService;
import com.finalProject.demo.service.product.ProductService;

/**
 * @author AJ
 *
 */
@Controller
@RequestMapping("/Back")
public class productUpdateDeleteController {
	
	ProductService productService;
	PhotoService photoService;
	
	@Autowired
	public productUpdateDeleteController(ProductService productService, PhotoService photoService) {
		super();
		this.productService = productService;
		this.photoService = photoService;
	}
	
	//刪除商品
		@GetMapping("/MyProduct/delete/{id}")
		public String deleteProduct(@PathVariable("id") String productId) {
			if(productService.existsById(productId)) {
				productService.deleteById(productId);	
			}
			return "redirect:/Back/MyProduct";
		}
		
		@GetMapping("/MyProduct/edit")
		public String productUpdate(@RequestParam("id")String id , Model model) {
			Products product = productService.findById(id);
			model.addAttribute("product",product);
			return"back/product/updateProduct";
		}
		
		
//		//修改單一商品功能post
//		@PostMapping("/Product/edit")
//		public String postUpdate(@RequestParam("product")Products editProduct,
//				@RequestParam("") reMultipartFile file) {
//			productService.addProduct(editProduct);
//			return"redirect:/Back/MyProduct";
//		}
		
		
	
	
	

}
