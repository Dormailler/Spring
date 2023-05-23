package annotation.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Component, @Service, @Repository <context:component-scan..> 있어야됨
@Controller
public class HelloController{
	@RequestMapping("/hello")
	public ModelAndView hello() throws Exception {
		HelloDTO dto = new HelloDTO();
		dto.setMessage("컨트롤러가 jsp로 전달하는 모델입니다.");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", dto);
		mv.setViewName("hello");
		return mv;
	}
	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", "hello2 url 실행중입니다.");
		mv.setViewName("hello2");
		return mv;
	}
	

}
