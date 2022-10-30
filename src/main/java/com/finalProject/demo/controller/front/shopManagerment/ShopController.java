package com.finalProject.demo.controller.front.shopManagerment;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalProject.demo.model.entity.cart.Cart;
import com.finalProject.demo.model.entity.order.OrderDetail;
import com.finalProject.demo.model.entity.product.Products;
import com.finalProject.demo.service.cart.CartService;
import com.finalProject.demo.service.product.PhotoService;
import com.finalProject.demo.service.product.ProductService;
import com.finalProject.demo.service.product.ShopService;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	 ProductService productService;
    PhotoService photoService;
    @Autowired
    CartService cartservice;
	
	
	/*
	 * 設定每頁有幾筆商品顯示在頁面上
	 * 第一頁:http://localhost:8080/Chezmoi/shop/page
	 * 第二頁:http://localhost:8080/Chezmoi/shop/page?p=2 以此類推
	 */
	@GetMapping("/shop")
	public String viewProducts(@RequestParam(name="p", defaultValue="1") Integer pageNumber,Model model) {
		Page<Products>page=shopService.findByPage(pageNumber);
		model.addAttribute("page", page);
//		Photo photo=photoService.findById(photoId);
//		model.addAttribute("Photo", photo);
		return "front/shop";
		
	}
	
	@GetMapping("/")
	public String viewIndexProducts(@RequestParam(name="p", defaultValue="1") Integer pageNumber,Model model) {
		Page<OrderDetail>page=shopService.findByPageIndex(pageNumber);
		model.addAttribute("page", page);
		return "front/index";
	}
	
	
	/*
	 * 設定按下商品分類可跳出相對應的商品
	 */
	@GetMapping("/shop/{category}")
	public String viewTopProducts(@PathVariable("category")String category,Model model) {
		List<Products> productcategory=shopService.findProductByCategory(category);
		model.addAttribute("category", productcategory);
		return "front/CatProduct";
		
	}

	/*
	 * 製作點擊商品名字可以進入"商品明細"
	 */
	@GetMapping("/shop/productDetail")
	public String productdetail(@RequestParam("productId")String productId,Model model) {
		Products product=shopService.findById(productId);
		model.addAttribute("Product", product);
		
		List<Products> productSeries=shopService.findBySeries(product.getSeries());
		model.addAttribute("productSeries",productSeries);
		return "front/productDetail";
	}
	
	
	
	

    
//    public myProductAllController(PhotoService photoService, ProductService productService) {
//        super();
//        this.photoService = photoService;
//        this.productService = productService;
//    }


//    @GetMapping(value = "/MyProduct",produces = { "application/json; charset=UTF-8" })//進入畫面就會顯示全部
//    public String getProducts(@RequestParam(name = "page",defaultValue = "1") Integer pageNumber, Model model) {
//        Page<Products> findByPage = productService.findByPage(pageNumber);
//        model.addAttribute("page",findByPage);
//        return "front/shop";
//    }
	
	

	
}

