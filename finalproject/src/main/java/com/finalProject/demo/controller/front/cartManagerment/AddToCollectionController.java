package com.finalProject.demo.controller.front.cartManagerment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.finalProject.demo.model.entity.cart.Collection;
import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.model.entity.product.Products;
import com.finalProject.demo.service.cart.CollectionService;
import com.finalProject.demo.service.product.ProductsService;

@Controller
@SessionAttributes("Member")
public class AddToCollectionController {

	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private CollectionService collectionService;
	

	//在shop頁面加入收藏
	//沒加會員的版本,new 空白收藏
	@GetMapping("/shop/addToCollection")
	public String addToCart(Model model,
			@RequestParam("id") String productId
			) {
		Member member = (Member) model.getAttribute("Member");
		Long memberId = member.getMemberId();
		Collection collection = new Collection();
		collection.setMemberId(memberId);
		collection.setProductId(productId);
		collectionService.insert(collection);
		return "redirect:/shop";
	}
	
	//在cart頁面加入收藏
	//沒加會員的版本,new 空白收藏
	@GetMapping("/cart/addToCollection")
	public String addToCartInCart(Model model,
			@RequestParam("id") String productId
			) {
		Member member = (Member) model.getAttribute("Member");
		Long memberId = member.getMemberId();
		Collection collection = new Collection();
		collection.setMemberId(memberId);
		collection.setProductId(productId);
		collectionService.insert(collection);
		return "redirect:/cartAll";
	}
	
	//取得所有Products
	@ModelAttribute("Products")
	public List<Products> viewProducts() {
		return productsService.findAllProducts();
	}
	
	//現在的會員是誰
	@ModelAttribute("Member")
	public Member viewMember(Model model) {
		Member memberLogin = new Member();
		memberLogin.setMemberId(1L);
		return memberLogin;
	}
	
}
