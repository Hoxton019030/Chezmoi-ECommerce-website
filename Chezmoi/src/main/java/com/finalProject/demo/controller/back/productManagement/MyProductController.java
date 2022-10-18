package com.finalProject.demo.controller.back.productManagement;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.finalProject.demo.model.entity.product.Products;
import com.finalProject.demo.service.product.PhotoService;
import com.finalProject.demo.service.product.ProductService;

@Controller
@RequestMapping("Back")
public class MyProductController {

	
	ProductService productService;
	PhotoService photoService;
	
	@Autowired
	public MyProductController(ProductService productService,PhotoService photo) {
		super();
		this.productService = productService;
		this.photoService = photo;
	}
	
	

	
	//myproduct index 全部商品
//	@GetMapping("MyProduct/all")
//	public String allProducts(@RequestParam(name = "page",defaultValue = "1") Integer pageNumber,Model model) {
//		Page<Products> findByPage = productService.findByPage(pageNumber);		
//		model.addAttribute("page",findByPage);
//		return"back/product/myProduct";
//	}
	

//	//刪除同系列商品功能 //EX.ID=D001全部刪除
//	@DeleteMapping("MyProduct/Delete/{id}")
//	public String deleteAllProducts(@PathVariable("id")String id) {
//		try {
//			if (productService.existsById(id)) {
//				String messageSuccess = "已刪除商品:/t"+"ID:"+id+"/t"+"商品名稱為:"+productService.findById(id).getName();
//				
//				productService.deleteProductById(id);
//				//不會顯示
//			}else {
//				String messageFail = "找不到ID為: "+id+" 的商品/t請確認是否有成功新增或已刪除";
//				System.out.println(messageFail);
//				return null;
//			}
//		} catch (IOException e) {
//			e.printStackTrace();		}
//		return"redirect:/back/MyProduct";
//	}
//	
//	
//	//刪除單一商品 EX.id=D001-S-Black才刪除
//	@DeleteMapping("MyProduct/Delete/{id}")
//	public String deleteOneProduct(@PathVariable("id")String id) {
//		
//	}
	
	
	//依分類顯示商品(category)
//	@ResponseBody
	@GetMapping("Get/MyProduct/findByCategory/{category}")
	public List<Products> findByCategory(@PathVariable("category")String category) {
		return productService.findByCategory(category);
	}
	
	//增加color
	
	
	
	//商品狀態(上架)
	
	
	//商品狀態(未上架)
}
