package com.finalProject.demo.controller.back.productManagement;

import com.finalProject.demo.model.entity.product.Photo;
import com.finalProject.demo.service.product.DescriptTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.finalProject.demo.model.entity.product.Products;
import com.finalProject.demo.service.product.PhotoService;
import com.finalProject.demo.service.product.ProductService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author AJ
 *
 */
@Controller
@RequestMapping("/Back")
public class productUpdateDeleteController {
	
	ProductService productService;
	PhotoService photoService;
	DescriptTextService descriptTextService;
	
	@Autowired
	public productUpdateDeleteController(ProductService productService, PhotoService photoService,DescriptTextService descriptTextService) {
		super();
		this.productService = productService;
		this.photoService = photoService;
		this.descriptTextService = descriptTextService;
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
		
		
		//修改單一商品功能post
		@PostMapping ("/MyProduct/edit")
		public String postUpdate(
				@ModelAttribute("product")Products product,
				@RequestParam(value = "mainProduct_pic",required = false) MultipartFile mainPic,
				@RequestParam(value = "fit_pic",required = false) MultipartFile fitPic,
				@RequestParam(value = "detail_pic",required = false) MultipartFile detailPics,
				@RequestParam(value = "descriptText",required = false) String text,
				@RequestParam(value = "color",required = false)String color,
				@RequestParam(value = "size",required = false)String size,
				@RequestParam("price")Integer price,
				HttpServletRequest request,
				Map<String,String> msgMap,
				Model model) {

			//photo




			//商品描述
			if (text.indexOf("\n")!=-1) {
				text = text.replace("\n", "<br>");
				if (text.indexOf(" ")!=-1) {
					text = text.replace(" ","&nbsp;");
				}
			}
			String descId = request.getParameter("descId");
			Long dId = Long.valueOf(descId);


			//商品update
			String newProductId;
			String category = request.getParameter("category");
			String productId = request.getParameter("productId");
			String changeId = productId.substring(0,4);
			char prefix = category.charAt(0);
			//判斷分類(將acc分類與其他分類分開)
			List<Products> all = productService.findAll();
			if (!(prefix=='A')){
				newProductId=changeId+"-"+size+"-"+color;
					if (!productService.existsById(newProductId)) {
						productService.updateById(newProductId, size, color, price, productId);
						descriptTextService.updateById(dId,text);
						System.out.println("11111111111111111111111");
						msgMap.put("msg","修改商品成功!");
						System.out.println();
					}else {
						System.out.println("商品重複!請重新選擇顏色及尺寸");
						msgMap.put("msg","商品重複!請重新選擇顏色及尺寸!");
						model.addAttribute("msg","商品重複!請重新選擇顏色及尺寸!");
						return"redirect:/Back/MyProduct/edit?id="+productId;
					}
			}else {
				if (product.getSize()!=null && !(product.getSize().isEmpty())){
					size = product.getSize();
					if (product.getColor()!=null && !(product.getColor().isEmpty())){
						color = product.getColor();
						newProductId=changeId+"-"+size+"-"+color;
						if (!productService.existsById(newProductId)) {
							productService.updateById(newProductId, size, color, price, productId);
							descriptTextService.updateById(dId,text);
						}else {
							System.out.println("商品重複!請重新選擇顏色及尺寸");
							return"redirect:/MyProduct/edit?id="+productId;
						}
					}else{
						newProductId = changeId+"-"+size;
						if (!productService.existsById(newProductId)) {
							productService.updateById(newProductId, size, color, price, productId);
							descriptTextService.updateById(dId,text);
						}else {
							System.out.println("商品重複!請重新選擇顏色及尺寸");
							return"redirect:/MyProduct/edit?id="+productId;
						}
					}
				}else {
					if (product.getColor()!=null && !(product.getColor().isEmpty())){
						newProductId = changeId+"-"+color;
						if (!productService.existsById(newProductId)) {
							productService.updateById(newProductId, size, color, price, productId);
							descriptTextService.updateById(dId,text);
						}else {
							System.out.println("商品重複!請重新選擇顏色及尺寸");
							return"redirect:MyProduct/edit?id="+productId;
						}

					}
				}
			}
//			if (!msgMap.isEmpty()){
//				return"forward:/Back/MyProduct/edit?id="+productId;
//			}
			return"redirect:/Back/MyProduct";
		
		//應該要做成當重複id時停留在當前畫面並跳出警告
			//成功則跳轉畫面
		}
	@GetMapping("/listGoodPhoto")
	public String listPhotoPage( Model model) {
		List<Photo> photos = photoService.findAll();
		model.addAttribute("goodPhotoList",photos);
		return "product/listPhoto";
	}
		
		
	
	
	

}
