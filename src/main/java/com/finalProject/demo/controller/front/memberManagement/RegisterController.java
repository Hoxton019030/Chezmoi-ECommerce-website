package com.finalProject.demo.controller.front.memberManagement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.service.member.MemberService;

@Controller
public class RegisterController {
	
	@Autowired
	private MemberService mService;
	
	@GetMapping("/member/register")
	public String addRegister(Model model) {
		
		Member m1 = new Member();
		model.addAttribute("register",m1);
		
		return "front/member/register";
	}
	
	// ----- 註冊成功畫面 -----
		@PostMapping("/member/register")
		public String postRegister(@ModelAttribute(name="registersubmit") Member member,RedirectAttributes re) {
			List<Member> resultList = mService.findEmail(member);
			if (resultList.size() > 0) {
				re.addAttribute("Msg", "帳號重複!");
				System.out.println("帳號重複!");
				return "redirect:/member/register";
			} else {
				mService.insert(member);
				re.addAttribute("Msg", "註冊成功!");
				System.out.println("註冊成功!");

				return "redirect:/member/login";
			}
		}
		
		
		// ===================================== 送出：修改使用者資料 =======================================
				@PostMapping("/member/usersubmit")
				public String UpdateUser(HttpServletRequest request, 
						@ModelAttribute(name="usersubmit")Member member, Model model) {
					System.out.println("===============送出修改按鈕=================");
					
					
					
//					String email = session.getAttribute("email").toString(); // 使用Session是因為要用抓這人的帳密來判斷這人的資料
//					String password = session.getAttribute("password").toString();
					System.out.println("id: " + member.getMemberId());
					              
					Member mmm = mService.insert(member);			// 把資料放進去(insert)
					if(mmm != null) {
						System.out.println("更新成功!");
//						model = getViewUser(request, model);		// 如果要顯示更新成功這三段就要開啟getViewUser方法
//						model.addAttribute("Msg", "更新成功!");
//						return "user/user";
						return "front/member/user";						// 使用此return是不會顯示更新成功
					}
					else {
						System.out.println("更新失敗!");
						model.addAttribute("Msg", "更新失敗!"); // 畫面顯示：更新失敗!
						return "front/member/login"; 		   // 返回登入畫面
					}
				}
	
}
