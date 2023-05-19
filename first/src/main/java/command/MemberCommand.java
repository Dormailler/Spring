package command;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("member")
public class MemberCommand implements Command {

	@Override
	public String run() {
		return "회원 : 관리중입니다.";

	}

}
