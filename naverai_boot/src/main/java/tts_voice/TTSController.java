package tts_voice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ai.MyNaverInform;
import com.example.ai.NaverService;

@Controller
public class TTSController {
	
	@Autowired
	@Qualifier("ttsservice")
	NaverService service;
	
	//ai_images 파일리스트 보여주는 뷰
	@RequestMapping("/ttsinput")
	public ModelAndView feceinput() {
		
		File f = new File(MyNaverInform.path); // 파일과 디렉토리 정보 제공		
		String[] filelist = f.list();
		
		//file_ext 배열 존재하는 확장자만 모델 포함
		String file_ext[] = {"txt"};
		ArrayList<String> newfilelist = new ArrayList();
		for(String file:filelist) {
			String myext = file.substring(file.lastIndexOf(".") + 1); //jpg
			for(String ext : file_ext) {
				if(myext.equals(ext)) {
					newfilelist.add(file);
					break;
				}
			}
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filelist", newfilelist);
		mv.setViewName("ttsinput");
		return mv;
	}
	
	@RequestMapping("/ttsresult")
	public ModelAndView feceresult(String text,String speaker) throws IOException {
		//서버클래스요청 
		String ttsresult = null;
		if(speaker == null) {
			ttsresult = service.test(text);
		}else {
			ttsresult = ((TTSServiceImpl)service).test(text,speaker);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("ttsresult", ttsresult);
		mv.setViewName("ttsresult");
		
		return mv;
	}

}
