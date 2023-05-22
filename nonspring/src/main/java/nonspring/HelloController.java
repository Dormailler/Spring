package nonspring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		//컨트롤러 역할 model 생성
		//view 정의 - model 전달
		HelloDTO dto = new HelloDTO();
		dto.setMessage("컨트롤러가 jsp로 전달하는 모델입니다.");
		request.setAttribute("model", dto);
		return "hello.jsp";

	}

}
