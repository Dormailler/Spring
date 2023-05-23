package annotation.springmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {

	@RequestMapping("list")
	public ModelAndView handleRequest() {
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
