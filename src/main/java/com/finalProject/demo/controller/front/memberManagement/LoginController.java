package com.finalProject.demo.controller.front.memberManagement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.service.member.MemberService;

@Controller
public class LoginController {

	@Autowired
	private MemberService mService;
	
	
	// ================================== 登入頁面 ==================================
	@GetMapping("/member/login") 								
	public String login(HttpServletRequest request) {   
		HttpSession session = request.getSession();
		Object email = session.getAttribute("email");
//		if (email != null) { 						// 如果已有登入未登入
//			 return "redirect:index";
//		} else {
			return "front/member/login"; 			// 找 /login.jsp 顯示畫面：登入畫面
//		}
	}
	
	// ================================== 登出頁面 ==================================
		@GetMapping("/member/logout")
		public String logout(HttpServletRequest request) { // 進入方法(login)
			HttpSession session = request.getSession();    // 使用 session
			session.removeAttribute("email"); 		       // 刪掉
			session.removeAttribute("password");
			return "redirect:index";
		}
		
	// ================================== 使用者登入：判斷帳密是否正確 ========================
		@RequestMapping("/member/loginsubmit")
		public String loginsubmit(HttpServletRequest request, @ModelAttribute(name = "loginsubmit") Member member,
				RedirectAttributes re) {
	// ---- 資料傳到SQL ------
			List<Member> resultList = mService.findLogin(member);

				System.out.println("==================== .登入. =========================");
				if (resultList.size() > 0) { 			   // 若資料庫沒有的帳密則登入失敗
					// 如果登入成功帳密存到Session
					// 第一步：獲取session
					HttpSession session = request.getSession();
					// 第二步：將想要保存到數據存入session中
					session.setAttribute("email", resultList.get(0).getEmail()); // 取得那欄位的帳號,從0(陣列)開始,放入session
					session.setAttribute("password", resultList.get(0).getPassword());
					
					// 完成了用戶名和密碼保存到session的操作
					System.out.println("登入成功");
					return "/front/index";
				
				} else {
					re.addAttribute("Msg", "登入失敗!"); 			   // 畫面顯示：登入失敗!
					return "redirect:/member/login"; 				   // 返回登入畫面
				}
		}

}
