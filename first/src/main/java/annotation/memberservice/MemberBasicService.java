package annotation.memberservice;

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
	public void registerMember() {
		boolean result = dao.selectMember();
		if(!result) {
			dao.insertMember();
		}

	}

}
