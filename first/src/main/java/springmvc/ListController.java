package springmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		ArrayList<String> list = new ArrayList();
		list.add("HelloDTO 모델객체1");
		list.add("HelloDTO 모델객체2");
		list.add("HelloDTO 모델객체3");
		mv.addObject("list", list);
		mv.setViewName("list");
		return mv;
	}

}
