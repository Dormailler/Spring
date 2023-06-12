package ocr;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.ai.MyNaverInform;
import com.example.ai.NaverService;

@Controller
public class OCRController {
	
	@Autowired
	@Qualifier("ocrservice")
	NaverService service;
	
	@RequestMapping("/ocrinput")
	public ModelAndView ocrinput() {
		File f = new File(MyNaverInform.path); // 파일과 디렉토리 정보 제공
		
		String[] filelist = f.list();
		
		//file_ext 배열 존재하는 확장자만 모델 포함
		String file_ext[] = {"jpg","gif","png","jfif"};
		ArrayList<String> filearray = new ArrayList();
		for(String file:filelist) {
			String myext = file.substring(file.lastIndexOf(".") + 1); //jpg
			for(String ext : file_ext) {
				if(myext.equals(ext)) {
					filearray.add(file);
					break;
				}
			}
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filearray", filearray);
		mv.setViewName("ocrinput");
		return mv;
	}
	
	
	
	@RequestMapping("/ocrresult")
	public ModelAndView ocrresult(String image) {
		String ocrresult = service.test(image);
		ModelAndView mv = new ModelAndView();
		mv.addObject("ocrresult", ocrresult);
		mv.setViewName("ocrresult");
		return mv;
	}
}
