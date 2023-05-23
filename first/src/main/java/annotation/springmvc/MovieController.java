package annotation.springmvc;

import java.util.HashMap;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {
	HashMap<String, Integer> moviemap = new HashMap();
	
	@RequestMapping("/movielist")
	public ModelAndView start() {
		moviemap.put("영화제목1", 19);
		moviemap.put("영화제목2", 13);
		moviemap.put("영화제목3", 19);
		moviemap.put("영화제목4", 0);
		Set<String> movielist = moviemap.keySet();
		ModelAndView mv = new ModelAndView();
		mv.addObject("movielist", movielist);
		mv.setViewName("movielist");
		return mv;
	}
	@RequestMapping("/moviereserve") // moviedto로바꿔보자
	public ModelAndView end(String memberid, int pw, int age, String[] mymovielist) {
		Set<String> moviSset = moviemap.keySet();
		String resultmovie = "";
		for(String mymovie : mymovielist) {
			for(String movie:moviSset) {
				if(movie.contains(mymovie) && moviemap.get(movie) <= age) {
					resultmovie += movie + " ";
				}
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberid", memberid);
		mv.addObject("age", age);
		mv.addObject("resultmovie", resultmovie);
		mv.setViewName("moviereserve");
		return mv;
	}
}
