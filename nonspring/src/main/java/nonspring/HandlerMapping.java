package nonspring;

import java.util.HashMap;

public class HandlerMapping {
	// hello url --- HelloController 컨트롤러에게 전달
	HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("hello", new HelloController());
		mappings.put("list", new ListController());
	}
	Controller getController(String url){
		return mappings.get(url);
	}
}
