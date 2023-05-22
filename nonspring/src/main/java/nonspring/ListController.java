package nonspring;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<String> list = new ArrayList();
		list.add("HelloDTO 모델객체1");
		list.add("HelloDTO 모델객체2");
		list.add("HelloDTO 모델객체3");
		request.setAttribute("list", list);
		return "list.jsp";
	}

}
