package com.finalProject.demo.controller.front.pageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WishTestController {

	@GetMapping("/wishTest")
	public String viewWishTest() {
		return "front/wishTest/wishTest";
	}
	
	@GetMapping("/wishTest/question")
	public String viewWishTestQuestion() {
		return "front/wishTest/question";
	}

}
