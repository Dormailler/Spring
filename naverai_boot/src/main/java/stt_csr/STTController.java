package stt_csr;

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
public class STTController {
	
	@Autowired
	@Qualifier("sttservice")
	NaverService service;
	
	//ai_images 파일리스트 보여주는 뷰
	@RequestMapping("/sttinput")
	public ModelAndView feceinput() {
		
		File f = new File(MyNaverInform.path); // 파일과 디렉토리 정보 제공		
		String[] filelist = f.list();
		
		//file_ext 배열 존재하는 확장자만 모델 포함
		String file_ext[] = {"mp3","m4a","wav"};
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
		mv.setViewName("sttinput");
		return mv;
	}
	
	@RequestMapping("/sttresult")
	public ModelAndView feceresult(String file,String lang) throws IOException {
		//서버클래스요청 
		String sttresult = null;
		if(lang == null) {
			sttresult = service.test(file);
		}else {
			sttresult = ((STTServiceImpl)service).test(file,lang);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("sttresult", sttresult);
		mv.setViewName("sttresult");
		
		//추가 MyNaverInfor.path 경로 mp3파일이름_2023060911022.txt파일로저장
		LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
		FileWriter fileWriter = new FileWriter(MyNaverInform.path + file +"_"+ formattedDateTime +".txt");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(sttresult);
        bufferedWriter.close();
		
		return mv;
	}

}
