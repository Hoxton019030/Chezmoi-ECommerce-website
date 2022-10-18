package com.finalProject.demo.controller.back.productManagement;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finalProject.demo.model.entity.product.Photo;
import com.finalProject.demo.model.entity.product.Products;
import com.finalProject.demo.service.product.PhotoService;
import com.finalProject.demo.service.product.ProductService;

/**
 * @author AJ
 *
 */
@Controller
@RequestMapping("/Back")
public class ProductsAddUpdateController {

	ProductService productService;
	PhotoService photoService;
	
	@Autowired
	public ProductsAddUpdateController(ProductService product,PhotoService photo) {
		super();
		this.productService = product;
		this.photoService = photo;
	}
	

	
	
	//新增商品Post
	@PostMapping(value={"/Product/add","/fileUpload"})
	public String postAddProduct(@ModelAttribute("product")Products product,
			@RequestParam("mainProduct_pic")MultipartFile mainPic,
			@RequestParam("mainProduct_pic")MultipartFile brandPic,
			@RequestParam("size")List<String> sizeList,
			@RequestParam("color")List<String> colorList,
			Model model) {
		
		//PHOTO
		Photo newphoto = new Photo();
		try {//嘗試:改成product.getphoto.getMailPic()
			newphoto.setMainProduct_pic(mainPic.getBytes());
			newphoto.setBrand_pic(brandPic.getBytes());
			photoService.addPhoto(newphoto);
			product.setPhoto(newphoto);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
		}
		/* 一一取得color、size，並新增 new product
		 *前端要增加判斷欄位(欄位都有才新增product!)
		 *
		 *因為還有同一商品，不同尺寸，不同顏色的問題，需要做成兩種不同的控制器
		 *一個為new product(新增商品系列)
		 *一個為new old product(在已經有舊商品的情況下，在那個系列下新增商品)
		 * */
		String size = null;
		String color = null;
		String productId=null;
		String getId = productService.newProductId(product.getCategory());
		if(sizeList.size()!=0 && colorList.size()!=0) {
			for(int i=0;i<sizeList.size();i++) {
				size=sizeList.get(i);
					for(int j=0; j<colorList.size();j++) {
						color = colorList.get(j);
						Products newProduct = new Products();
						newProduct.setColor(color);
						newProduct.setSize(size);
						newProduct.setCategory(product.getCategory());
						newProduct.setName(product.getName());
						newProduct.setPrice(product.getPrice());
						newProduct.setPhoto(product.getPhoto());
						newProduct.setDescriptText(product.getDescriptText());
						productId=getId+"-"+size+"-"+color;
						newProduct.setProductId(productId);
						
						try {
							productService.addProduct(newProduct);	
							if(productService.existsById(newProduct.getProductId())) {
								System.out.println("新增商品成功!商品Id為:"+newProduct.getProductId()+"商品名稱為:"+newProduct.getName());
							}
						} catch (Exception ex) {
							System.out.println(ex.getClass().getName() + ", ex.getMessage()=" + ex.getMessage());
						}

					}
			}
		}
		//刷新頁面
		model.addAttribute("product",new Products());
		return "back/product/addProduct";
	}
	
	
	//刪除商品
	@DeleteMapping("/MyProduct/delete/{id}")
	public String deleteProduct(@PathVariable("id") String productId) {
		if(productService.existsById(productId)) {
			productService.deleteById(productId);
			System.out.println("刪除ID="+productId+"商品成功");	
		}return "redirect:/Back/MyProduct";
	}
	
	//修改單一商品功能post
	@PostMapping("Post/editProduct")
	public String postUpdate(@RequestParam("product")Products editProduct) {
		productService.addProduct(editProduct);
		return"redirect:/Back/Get/MyProduct";

	//增加單一商品(顯示在MyProduct頁)
		
		
		
	}
	
	
	
	
	
	
}
     