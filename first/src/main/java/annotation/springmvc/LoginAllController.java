package annotation.springmvc;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAllController{
	
	// get 
	//@RequestMapping(value="login",method=RequestMethod.GET) // @Requestmapping 선언 메소드 리턴라입 String - view 이름 간주
	@GetMapping("/login")
	public String form(){
		return "loginform";
	}	
	
	//test5
	@PostMapping("/login")
	//xxxMapping 메소드 매개변수로 클래스 선언 - 자동주입하고 해당 객체를 모델로 자동 저장
	public String result(@ModelAttribute LoginDTO dto){
		//LoginDTO dto = new LoginDTO();
		//dto.setMemberid(id);
		//dto.setPw(pw);
		//ModelAndView mv = new ModelAndView();
		//mv.addObject("logindto", dto);
		//mv.setViewName("loginresult");
		return "loginresult";
	}
		
	//test4
	//@PostMapping("/login")
	//xxxMapping 메소드 매개변수로 클래스 선언 - 클래스 멤버면수명 = 요청파라미터명 자동 주입
//	public ModelAndView result(LoginDTO dto){
//		//LoginDTO dto = new LoginDTO();
//		//dto.setMemberid(id);
//		//dto.setPw(pw);
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("logindto", dto);
//		mv.setViewName("loginresult");
//		return mv;
//	}
		
	//test3
	//@PostMapping("/login")
	/*public ModelAndView result(@RequestParam(value="memberid", required=false,defaultValue = "아이디") String id, int pw) throws Exception  {
		//request.setCharacterEncoding("utf-8");
		LoginDTO dto = new LoginDTO();
		//String memberid = request.getParameter("memberid");
		//int pw = Integer.parseInt(request.getParameter("pw")); 
		dto.setMemberid(id);
		dto.setPw(pw);
		ModelAndView mv = new ModelAndView();
		mv.addObject("logindto", dto);
		mv.setViewName("loginresult");
		return mv;
	}*/
	
	//test2
	//@PostMapping("/login")
	//@xxxMapping 메소드 매개변수 요청파라미터이름 동일하다면 자동 저장
	/*public ModelAndView result(String memberid, int pw) throws Exception  {
		//request.setCharacterEncoding("utf-8");
		LoginDTO dto = new LoginDTO();
		//String memberid = request.getParameter("memberid");
		//int pw = Integer.parseInt(request.getParameter("pw")); 
		dto.setMemberid(memberid);
		dto.setPw(pw);
		ModelAndView mv = new ModelAndView();
		mv.addObject("logindto", dto);
		mv.setViewName("loginresult");
		return mv;
	}*/
	// post test1
	//@RequestMapping(value="login",method=RequestMethod.POST)
	/*@PostMapping("/login")
	public ModelAndView result(HttpServletRequest request) throws Exception  {
		request.setCharacterEncoding("utf-8");
		LoginDTO dto = new LoginDTO();
		String memberid = request.getParameter("memberid");
		int pw = Integer.parseInt(request.getParameter("pw")); 
		dto.setMemberid(memberid);
		dto.setPw(pw);
		ModelAndView mv = new ModelAndView();
		mv.addObject("logindto", dto);
		mv.setViewName("loginresult");
		return mv;
	}*/
}
