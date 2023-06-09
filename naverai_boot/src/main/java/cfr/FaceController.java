package cfr;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ai.MyNaverInform;
import com.example.ai.NaverService;

@Controller
public class FaceController {
	
	@Autowired
	@Qualifier("faceservice1")
	NaverService service;
	
	@Autowired
	@Qualifier("faceservice2")
	NaverService service2;
	
	//ai_images 파일리스트 보여주는 뷰
	@RequestMapping("/faceinput")
	public ModelAndView feceinput() {
		File f = new File(MyNaverInform.path); // 파일과 디렉토리 정보 제공
		
		String[] filelist = f.list();
		
		//file_ext 배열 존재하는 확장자만 모델 포함
		String file_ext[] = {"jpg","gif","png","jfif"};
		ArrayList<String> filearray = new ArrayList();
		for(String file:filelist) {
			/*for(String ext : file_ext) {
				if(file.contains(ext)) {
					filearray.add(file);
					break;
				}
			}*/
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
		mv.setViewName("faceinput");
		return mv;
	}
	
	@RequestMapping("/faceresult")
	public ModelAndView feceresult(String image) {
		//서버클래스요청 
		String faceresult = service.test(image);
		ModelAndView mv = new ModelAndView();
		mv.addObject("faceresult", faceresult);
		mv.setViewName("faceresult");
		return mv;
	}
	
	//안면인식서비스 파일리스트
	@RequestMapping("/faceinput2")
	public ModelAndView feceinput2() {
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
		mv.setViewName("faceinput2");
		return mv;
	}
	
	@RequestMapping("/faceresult2")
	public ModelAndView feceresult2(String image) {
		//서버클래스요청 
		String faceresult2 = service2.test(image);
		ModelAndView mv = new ModelAndView();
		mv.addObject("faceresult2", faceresult2);
		//mv.setViewName("faceresult2");
		mv.setViewName("faceresult3"); // canvas (이미지 도형) 얼굴 사각형 표시
		return mv;
	}
}
