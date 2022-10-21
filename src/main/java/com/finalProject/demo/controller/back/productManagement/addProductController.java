package com.finalProject.demo.controller.back.productManagement;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finalProject.demo.model.entity.product.DescriptText;
import com.finalProject.demo.model.entity.product.Photo;
import com.finalProject.demo.model.entity.product.Products;
import com.finalProject.demo.service.product.DescriptTextService;
import com.finalProject.demo.service.product.PhotoService;
import com.finalProject.demo.service.product.ProductService;

/**
 * @author AJ
 *
 */
@Controller
@RequestMapping("/Back")
public class addProductController {

	ProductService productService;
	PhotoService photoService;
	DescriptTextService descriptTextService; 
	
	@Autowired
	public addProductController(ProductService productService, PhotoService photoService,
			DescriptTextService descriptTextService) {
		super();
		this.productService = productService;
		this.photoService = photoService;
		this.descriptTextService = descriptTextService;
	}
	
	
	//新增商品Post
	/**
	 * @param product
	 * @param mainPic
	 * @param brandPic
	 * @param sizeList
	 * @param colorList
	 * @param model
	 * @return
	 */
	@PostMapping(value={"/Product/add","/fileUpload"})
	public String postAddProduct(
			@ModelAttribute("product")Products product,
			@RequestParam(value = "mainProduct_pic",required = false)MultipartFile mainPic,
			@RequestParam(value = "mainProduct_pic",required = false)MultipartFile brandPic,
			@RequestParam(value = "size",required = false)List<String> sizeList,
			@RequestParam(value = "color",required=false)List<String> colorList,
			@RequestParam(value = "descriptText",required = false) String descriptText,
			Model model) {
		
		//PHOTO(10.19需增加判斷)
		Photo newphoto = new Photo();
		try {
			newphoto.setMainProduct_pic(mainPic.getBytes());
			newphoto.setFit_pic(brandPic.getBytes());
			photoService.addPhoto(newphoto);
			product.setPhoto(newphoto);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
		}
		/* 一一取得color、size，並新增 new product
		 *前端要增加判斷欄位(欄位都有才新增product!)/除了Acc可以不用全部都要
		 *
		 *因為還有同一商品，不同尺寸，不同顏色的問題，需要做成兩種不同的控制器
		 *一個為new product(新增商品系列)
		 *一個為new old product(在已經有舊商品的情況下，在那個系列下新增商品)
		 * */
		
		//處理商品描述
		var text = new DescriptText();
		text.setText(descriptText);
		descriptTextService.save(text);
		product.setDescript(text);
		
		
		String size ;
		String color;
		String productId;
		String createId = productService.newProductId(product.getCategory());
		Products newProduct = new Products();
		//判斷分類(將acc分類與其他分類分開)
		if((product.getCategory()!=null) && (!product.getCategory().isEmpty())) {
			if(!product.getCategory().equals("Accessories")) {
				//判斷list中有無顏色及尺寸
				if(( sizeList!=null&&(!sizeList.isEmpty())) && (colorList!=null&&(!colorList.isEmpty()))) {	
					for(int i=0;i<sizeList.size();i++) {
						size=sizeList.get(i);
							for(int j=0; j<colorList.size();j++) {
								color = colorList.get(j);
								newProduct.setColor(color);
								newProduct.setSize(size);
								newProduct.setCategory(product.getCategory());
								newProduct.setName(product.getName());
								newProduct.setPrice(product.getPrice());
								newProduct.setPhoto(product.getPhoto());
								newProduct.setDescript(product.getDescript());
								productId=createId+"-"+size+"-"+color;
								newProduct.setProductId(productId);
								newProduct.setProductState("ON");
								
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
				
			}
			//類別為acc時執行
			else {
				if(sizeList!=null && (!sizeList.isEmpty()) ) {
					for(int i=0;i<sizeList.size();i++) {
						size = sizeList.get(i);
						newProduct.setSize(size);
						if(colorList!=null && !(colorList.isEmpty())) {
							for(int j=0;j<colorList.size();j++) {
							//size&color 都有
								color=colorList.get(j);
								newProduct.setColor(color);
								productId=createId+"-"+size+"-"+color;
								newProduct.setProductId(productId);
								newProduct.setCategory(product.getCategory());
								newProduct.setName(product.getName());
								newProduct.setPrice(product.getPrice());
								newProduct.setPhoto(product.getPhoto());
								newProduct.setDescript(product.getDescript());
								newProduct.setProductState("ON");
								try {
									productService.addProduct(newProduct);	
									if(productService.existsById(newProduct.getProductId())) {
										System.out.println("新增商品成功!商品Id為:"+newProduct.getProductId()+"商品名稱為:"+newProduct.getName());
									}
								} catch (Exception ex) {
									System.out.println(ex.getClass().getName() + ", ex.getMessage()=" + ex.getMessage());
								}
							}
						}else {
							//沒有color只有size	
							productId=createId+"-"+size;
							newProduct.setProductId(productId);
							newProduct.setCategory(product.getCategory());
							newProduct.setName(product.getName());
							newProduct.setPrice(product.getPrice());
							newProduct.setPhoto(product.getPhoto());
							newProduct.setDescript(product.getDescript());
							newProduct.setProductState("ON");
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
					
				}else {
					if(colorList!=null && !(colorList.isEmpty())) {
						for(int j=0;j<colorList.size();j++) {
							color=colorList.get(j);
							newProduct.setColor(color);
							productId=createId+"-"+color;
							newProduct.setProductId(productId);
							newProduct.setCategory(product.getCategory());
							newProduct.setName(product.getName());
							newProduct.setPrice(product.getPrice());
							newProduct.setPhoto(product.getPhoto());
							newProduct.setDescript(product.getDescript());
							newProduct.setProductState("ON");
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
				
			}
			
		}
		//顯示錯誤訊息(未選擇分類)
		
		//刷新頁面
		model.addAttribute("product",new Products());
		return "back/product/addProduct";
	}

	
	
	
	//增加單一商品(顯示在MyProduct頁)
		
		
		
	
	
	
	
	
	
	
}
     