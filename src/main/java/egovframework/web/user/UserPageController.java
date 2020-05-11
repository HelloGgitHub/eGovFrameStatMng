package egovframework.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class UserPageController {
	
	@RequestMapping("/MemberListPage") 
	public String welcome(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("+++++++++++++++++MemberListPage Page++++++++++++");
		return "MemberList"; 
	} 
	
	@RequestMapping("/corsTest") 
	public String crosTest(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++ddddddddddddddddddd++corsTest Page++++++++++++");
		return "corsTest"; 
	} 
	
	@RequestMapping("/MemberListPageA") 
	public String welcomeA(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++++MemberListPageA Page+++++++++++");
		return "EgovMberManage"; 
	} 

	@RequestMapping("/MemberInfo") 
	public String MemberInfo(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++MemberInfo Page++++++++++++");
		return "MemberInfo"; 
	}
	
	@RequestMapping("/EgovMemberInfo") 
	public String EgovMemberInfo(Model model) {
		System.out.println("++++++++++++++++EgovMemberInfo Page++++++++++++");
		return "EgovMemberInfo"; 
	} 
}
