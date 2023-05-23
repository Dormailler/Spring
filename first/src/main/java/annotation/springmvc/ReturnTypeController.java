package annotation.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller	
public class ReturnTypeController {
	
	@RequestMapping("/a")
	public ModelAndView a() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", "a메소드호출결과");
		mv.setViewName("aa");
		return mv;
	}
	@RequestMapping("/b")
	public String b() {
		return "bb"; //시작페이지 폼화면뷰
	}
	@RequestMapping("/c")
	public void c() { // 리턴타입 void 요청했던 url과 같은 jsp찾음
		System.out.println("리턴타입 void 입니다.");
	}
	@RequestMapping("/d")
	public void d(@ModelAttribute("dto") LoginDTO dto) { // 리턴타입 void 요청했던 url과 같은 jsp찾음
		System.out.println("리턴타입 void 입니다.");
	}
	@RequestMapping("/e")
	public String e() { 
		//return "aa"; //aa.jsp뷰(모델정보x)
		return "redirect:/a"; // '/a' url로 redirect
	}
}
