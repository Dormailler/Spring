package springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginResultController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginDTO dto = new LoginDTO();
		String memberid = request.getParameter("memberid");
		int pw = Integer.parseInt(request.getParameter("pw")); 
		dto.setMemberid(memberid);
		dto.setPw(pw);
		ModelAndView mv = new ModelAndView();
		mv.addObject("logindto", dto);
		mv.setViewName("loginresult");
		return mv;
	}	
}
