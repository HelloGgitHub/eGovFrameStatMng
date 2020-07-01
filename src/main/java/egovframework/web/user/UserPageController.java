package egovframework.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class UserPageController {
	
	@RequestMapping("/") 
	public String Main(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++Main Page++++++++++++");
		return "MainPage"; 
	}

	@RequestMapping("/FrameLeft") 
	public String FrameLeft(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++LeftMenu Page++++++++++++");
		return "FrameLeft"; 
	}
	@RequestMapping("/FrameTop") 
	public String FrameTop(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++LeftTop Page++++++++++++");
		return "FrameTop"; 
	}
	
	@RequestMapping("/DashBoard") 
	public String Login(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++UserInfo Page++++++++++++");
		return "DashBoard"; 
	}

	@RequestMapping("/ServerInfoList") 
	public String ServerInfoList(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++++ServerInfoList Page+++++++++++");
		return "ServerInfoList"; 
	} 
	
	@RequestMapping("/JobFncList") 
	public String JobFncList(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++++JobFncList Page+++++++++++");
		return "JobFncList"; 
	} 
	
	@RequestMapping("/ScrInfoList") 
	public String ScrInfoList(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++++ScrInfoList Page+++++++++++");
		return "ScrInfoList"; 
	} 
	
	@RequestMapping("/ScrStatList") 
	public String ScrStatList(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++++ScrStatList Page+++++++++++");
		return "ScrStatList"; 
	} 
	
	@RequestMapping("/ResultIndexList") 
	public String ResultIndexList(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++++ResultIndexList Page+++++++++++");
		return "ResultIndexList"; 
	}
	
	@RequestMapping("/ActiveUserList") 
	public String ActiveUserList(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++++ActiveUserList Page+++++++++++");
		return "ActiveUserList"; 
	}
	
	@RequestMapping("/UserMonthStatList") 
	public String UserMonthStatList(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++++UserMonthStatList Page+++++++++++");
		return "UserMonthStatList"; 
	}
	
	@RequestMapping("/ResourceUseStatList") 
	public String ResourceUseStatList(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++++++ResourceUseStatList Page+++++++++++");
		return "ResourceUseStatList"; 
	}
	
	
	
	
	@RequestMapping("/UserInfo") 
	public String MemberInfo(Model model
			, @RequestParam(value = "callType") String callType
			, @RequestParam(value = "userId") String userId) {
		model.addAttribute("msg", "jstl");
		model.addAttribute("callType", 	callType);
		model.addAttribute("userId", 		userId);
		
		System.out.println("++++++++++++++++UserInfo Page++++++++++++userId::"+ userId + "===callType :: "+callType);
		return "UserInfo"; 
	}

	
	

	
	
	
	
	
	
	
	@RequestMapping("/corsTest") 
	public String crosTest(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("++++++++++++++ddddddddddddddddddd++corsTest Page++++++++++++");
		return "corsTest"; 
	} 
	
	@RequestMapping("/UserListPageJson") 
	public String welcome(Model model) {
		model.addAttribute("msg", "jstl");
		System.out.println("+++++++++++++++++UserListPage Page++++++++++++");
		return "UserList"; 
	}
}
