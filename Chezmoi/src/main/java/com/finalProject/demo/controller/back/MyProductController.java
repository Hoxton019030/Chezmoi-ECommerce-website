//package com.finalProject.demo.controller.back;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.finalProject.demo.model.entity.product.Category;
//import com.finalProject.demo.model.entity.product.Products;
//import com.finalProject.demo.service.product.CategoryService;
//import com.finalProject.demo.service.product.ColorService;
//import com.finalProject.demo.service.product.PhotoService;
//import com.finalProject.demo.service.product.ProductService;
//import com.finalProject.demo.service.product.SizeService;
//
//@Controller
//@RequestMapping("Back")
//public class MyProductController {
//
//	
//	ProductService productService;
//	CategoryService categoryService;
//	ColorService colorService;
//	SizeService sizeService;
//	PhotoService photoService;
//	
//	@Autowired
//	public MyProductController(ProductService productService, CategoryService category, ColorService color,
//			SizeService size, PhotoService photo) {
//		super();
//		this.productService = productService;
//		this.categoryService = category;
//		this.colorService = color;
//		this.sizeService = size;
//		this.photoService = photo;
//	}
//	
//	//myproduct index 全部商品
//	@GetMapping("Get/MyProduct/products")
//	public String allProducts(@RequestParam(name = "page",defaultValue = "1") Integer pageNumber,Model model) {
//		Page<Products> findByPage = productService.findByPage(pageNumber);		
//		model.addAttribute("page",findByPage);
//		return"back/product/myProduct";
//	}
//	
//	@ResponseBody
//	@GetMapping("Get/Products")
//	public List<Products> allProducts() {
//		
//		return productService.findAll(); 
//	}
//
//	//刪除商品功能ok
//	@DeleteMapping("Delete/MyProduct/{id}")
//	public String deleteProduct(@PathVariable("id")Long id,HttpServletResponse response) {
//		response.setContentType("text/html;charset=UTF-8");//轉碼
//		try {
//			PrintWriter out = response.getWriter();
//			if (productService.existsById(id)) {
//				String messageSuccess = "已刪除商品:/t"+"ID:"+id+"/t"+"商品名稱為:"+productService.findById(id).getName();
//				
//				productService.deleteProductById(id);
//				//不會顯示
//				out.print("<script language='javascript' type='text/javascript'alert('"+messageSuccess+"');</script>");
//			}else {
//				String messageFail = "找不到ID為: "+id+" 的商品/t請確認是否有成功新增或已刪除";
//				out.print("<script language='javascript' type='text/javascript'alert('"+messageFail+"');</script>");
//				System.out.println("查無此筆商品");
//				return null;
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return"redirect:/back/MyProduct";
//	}
//	
//	
//	//依分類顯示商品(category)
////	@ResponseBody
//	@GetMapping("Get/MyProduct/findByCategory/{id}")
//	public List<Products> findByCategory(@PathVariable("id")Integer id) {
//		Category category = categoryService.findById(id);
//		return productService.findByCategory(category);
//	}
//	
//	//增加color
//	
//	
//	
//	//商品狀態(上架)
//	
//	
//	//商品狀態(未上架)
//	
//	
//	
//
//	
//}
