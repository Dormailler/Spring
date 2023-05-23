package annotation.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("basicservice")
public class MemberBasicService implements MemberService {
	@Autowired
	MemberDAO dao;

	MemberBasicService(){
		System.out.println("MemberBasicService 객체생성");
	}
	@Override
	public String registerMember(MemberDTO dto) {
		boolean result = dao.selectMember(dto);
		if(!result) {
			dao.insertMember(dto);
			return "포인트없이 회원가입되셨습니다.";
		}else {
			return "이미 존재하는 아이디입니다.";
		}

	}

}
