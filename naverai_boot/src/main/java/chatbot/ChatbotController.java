package chatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatbotController {
	
	@Autowired
	@Qualifier("chatbotservice")
	ChatbotServiceImpl service;
	
	@RequestMapping("/chatbotrequest")
	public String chatbotrequest() {
		return "chatbotrequest";
	}
	
	@RequestMapping("/chatbotresponse")
	public ModelAndView chatbotresponse(String request, String event) {
		String response = "";
		if(event.equals("웰컴메시지")) {
			response = service.test(request,"open");
		}else {
			response = service.test(request,"send");
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("response",response);
		mv.setViewName("chatbotresponse");
		return mv;
	}
	
	@RequestMapping("/chatbotajaxstart")
	public String chatbotajaxstart() {
		return "chatbotajaxstart";
	}
	
	@RequestMapping("/chatbotajaxprocess")
	@ResponseBody
	public String chatbotajaxprocess(String request, String event) {
		String response = "";
		if(event.equals("웰컴메시지")) {
			response = service.test(request,"open");
		}else {
			response = service.test(request,"send");
		}
		return response;
	}
	
	@RequestMapping("/chatbotajax")
	public String chatbotajax() {
		return "chatbotajax";
	}
}
