package nonspring;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/") //http://localhost:8081/nonspring/hello --> hello 
public class DispatchServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // /nonspring/hello
		String[] uri_array = uri.split("/");
		String result = uri_array[uri_array.length-1];
		System.out.println("요청uri=" + result );
		
		HandlerMapping mappings = new HandlerMapping();
		Controller controller = mappings.getController(result);
		
		String viewname = controller.handleRequest(req, resp);
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewname);
		dispatcher.forward(req, resp);
	}

}
