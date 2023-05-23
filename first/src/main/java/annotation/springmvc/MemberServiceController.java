package annotation.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberServiceController {
	@Autowired
	@Qualifier("basicservice")
	MemberService basicservice;
	
	@Autowired
	@Qualifier("janservice") 
	MemberService janservice;
	
	@GetMapping("/memberservice")
	public void memberservice() {
		//return "memberservice";
	}
	
	@PostMapping("/memberservice")
	public ModelAndView memberserviceresult(MemberDTO dto) {
		ModelAndView mv = new ModelAndView();
		//1월가입자 처리 MemberJanService registermember() 메소드 호출
		//MemberJanService service = new Me	mberJanService();
		String result = "";
		String month = dto.getRegtime().split("-")[1];
		if(month.equals("01")) {
			result = janservice.registerMember(dto);
		}else {
			result = basicservice.registerMember(dto);
		}
		mv.addObject("result", result);
		mv.setViewName("memberserviceresult");
		return mv;
	}
}
