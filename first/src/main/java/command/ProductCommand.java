package command;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("product")
public class ProductCommand implements Command {

	@Override
	public String run() {
		return "상품정보 : 등록중입니다.";

	}

}
