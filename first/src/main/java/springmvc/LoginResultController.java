package springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginResultController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginDTO dto = new LoginDTO();
		String id = request.getParameter("id");
		int pw = Integer.parseInt(request.getParameter("pw")); 
		dto.setMemberid(id);
		dto.setPw(pw);
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.addObject("pw", pw);
		mv.setViewName("loginresult");
		return mv;
	}	
}
