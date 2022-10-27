package com.finalProject.demo.controller.front.pageController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.finalProject.demo.model.entity.cart.Collection;
import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.service.cart.CollectionService;

@Controller
@SessionAttributes("Member")
public class CollectionController {

	@Autowired
	private CollectionService CollectionService;

	//顯示收藏商品
	@GetMapping("/collection")
	public String viewCollection(Model model1,Model model2) {
		List<Collection> findAll = CollectionService.findAllCollection();
		Member member=(Member) model1.getAttribute("Member");
		Long memberId = member.getMemberId();
		List<Collection> collectionList = new ArrayList<>();
		for(Collection collection:findAll) {
			Long memberId2 = collection.getMemberId();
			if(memberId.equals(memberId2)) {
				collectionList.add(collection);
			}
		}
		model2.addAttribute("Collection",collectionList);
		return "front/cart/collection";
	}
	
	//現在的會員是誰
	@ModelAttribute("Member")
	public Member viewMember(Model model) {
		Member memberLogin = new Member();
		memberLogin.setMemberId(2L);
		return memberLogin;
	}
}
