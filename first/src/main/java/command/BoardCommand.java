package command;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("board")
public class BoardCommand implements Command {

	@Override
	public String run() {
		return "게시판 : 실행중입니다.";

	}
	public void insertBoard() {
		System.out.println("BoardCommand : insertBoard");
	}
	int seq;
}
