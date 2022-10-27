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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
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

	@GetMapping("/MyProduct/edit/{id}")
	public String productUpdate(@PathVariable("id")String id , Model model) {
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
			Model model,
			RedirectAttributes ra) {

		//photo




		//商品描述
		if (text.contains("\n")) {
			text = text.replace("\n", "<br>");
			if (text.contains(" ")) {
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
				msgMap.put("msg","修改商品成功!新的商品ID為:"+newProductId);
			}else {
				ra.addAttribute("msg","商品重複!請重新選擇顏色及尺寸!");
				return"redirect:/Back/MyProduct/edit/"+productId;
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
						msgMap.put("msg","修改商品成功!新的商品ID為:"+newProductId);
					}else {
						ra.addAttribute("msg","商品重複!請重新選擇顏色及尺寸!");
						return"redirect:/Back/MyProduct/edit/"+productId;
					}
				}else{
					newProductId = changeId+"-"+size;
					if (!productService.existsById(newProductId)) {
						productService.updateById(newProductId, size, color, price, productId);
						descriptTextService.updateById(dId,text);
						msgMap.put("msg","修改商品成功!新的商品ID為:"+newProductId);
					}else {
						ra.addAttribute("msg","商品重複!請重新選擇顏色及尺寸!");
						return"redirect:/Back/MyProduct/edit/"+productId;
					}
				}
			}else {
				if (product.getColor()!=null && !(product.getColor().isEmpty())){
					newProductId = changeId+"-"+color;
					if (!productService.existsById(newProductId)) {
						productService.updateById(newProductId, size, color, price, productId);
						descriptTextService.updateById(dId,text);
						msgMap.put("msg","修改商品成功!新的商品ID為:"+newProductId);
					}else {
						ra.addAttribute("msg","商品重複!請重新選擇顏色及尺寸!");
						return"redirect:/Back/MyProduct/edit/"+productId;
					}

				}
			}
		}
		return"redirect:/Back/MyProduct";
	}
}
