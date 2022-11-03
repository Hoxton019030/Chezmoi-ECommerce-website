package com.finalProject.demo.controller.front.memberManagement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String login(HttpServletRequest request,@ModelAttribute(name = "loginsubmit") Member member) {   
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
			session.removeAttribute("login"); 		       // 刪掉
//			session.removeAttribute("password");r
			return "redirect:index";
		}
		
	// ================================== 使用者登入：判斷帳密是否正確 ========================
		@PostMapping("/member/loginsubmit")
		public String loginsubmit(HttpServletRequest request, @ModelAttribute(name = "loginsubmit") Member member,
				RedirectAttributes re) {
	// ---- 資料傳到SQL ------
			List<Member> resultList = mService.findLogin(member.getEmail(),member.getPassword());

				System.out.println("==================== .登入. =========================");
				if (resultList.size() > 0) { 			   // 若資料庫沒有的帳密則登入失敗
					// 如果登入成功帳密存到Session
					// 第一步：獲取session
					HttpSession session = request.getSession();
					// 第二步：將想要保存到數據存入session中
					Member mb = resultList.get(0);
					session.setAttribute("login", mb); // 取得那欄位的帳號,從0(陣列)開始,放入session
//					session.setAttribute("password", resultList.get(0).getPassword());
					
					// 完成了用戶名和密碼保存到session的操作
					System.out.println("登入成功");
					return "/front/index";
				} else {
					re.addAttribute("Msg", "登入失敗!"); 	// 畫面顯示：登入失敗!
					System.out.println("登入失敗");
					return "redirect:/member/login"; 		 // 返回登入畫面，這是找方法，例 此為@GetMapping("/member/login")
				}
		}
		// ---- 顯示修改會員資料 ----
		@GetMapping("/member/user")
		public String viewUser(HttpServletRequest request, Member member, Model model) {
			HttpSession session = request.getSession();
			Member user = (Member) session.getAttribute("login"); // 使用Session是因為要用抓這人的帳密來判斷這人的資料
			
			if (user != null){
				// 表示有資料
//				model.addAttribute("email", userList.get(0).getEmail());
//				model.addAttribute("memberName", userList.get(0).getMemberName());
//				model.addAttribute("birthday", userList.get(0).getBirthday());
//				model.addAttribute("phone", userList.get(0).getPhone());
				model.addAttribute("usersubmit", user);
				return "front/member/user";
			}else {
				//表示帳密錯誤 或者Session有問題
				session.removeAttribute("email"); 	// 刪掉
				session.removeAttribute("password");
				return "redirect:index";
				
			}
		}
		// ===================================== 送出：修改使用者資料 =======================================
		@PostMapping("/member/usersubmit")
		public String UpdateUser(HttpServletRequest request, 
				@ModelAttribute(name="usersubmit")Member member, Model model) {
			System.out.println("===============送出修改按鈕=================");
			
			HttpSession session = request.getSession();
//			String email = session.getAttribute("email").toString(); // 使用Session是因為要用抓這人的帳密來判斷這人的資料
//			String password = session.getAttribute("password").toString();
			System.out.println("id: " + member.getMemberId());
			              
			Member mmm = mService.insert(member);			// 把資料放進去(insert)
			if(mmm != null) {
				System.out.println("更新成功!");
//				model = getViewUser(request, model);		// 如果要顯示更新成功這三段就要開啟getViewUser方法
//				model.addAttribute("Msg", "更新成功!");
//				return "user/user";
				return "front/member/user";						// 使用此return是不會顯示更新成功
			}
			else {
				System.out.println("更新失敗!");
				model.addAttribute("Msg", "更新失敗!"); // 畫面顯示：更新失敗!
				return "front/member/login"; 		   // 返回登入畫面
			}
		}
}
