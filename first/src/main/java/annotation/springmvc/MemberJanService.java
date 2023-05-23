package annotation.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("janservice")
public class MemberJanService implements MemberService {
	@Autowired
	MemberDAO dao;
	@Autowired
	PointDAO dao2;
	
	MemberJanService(){
		System.out.println("MemberJanService 객체생성");
	}
	@Override
	public String registerMember(MemberDTO dto) {
		boolean result = dao.selectMember(dto);
		if(!result) {
			dao.insertMember(dto);
			dao2.setPoint(1000); //<property name="point" value="1000">
			System.out.println(dao2.getPoint() + " 포인트를 받았습니다");
			return dao2.getPoint() + " 포인트를 받고 회원가입되셨습니다.";
		}else {
			return "이미 존재하는 아이디입니다.";
		}

	}

}
