package member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("member/member.xml");
		//MemberDTO dto = (MemberDTO)factory.getBean("dto");
		MemberDAO dao = (MemberDAO)factory.getBean("dao");

		boolean result = dao.selectMember();
		if(result == true) {
			System.out.println(dao.dto.getMemberid() + "님 정상 로그인 사용자입니다.");
		}else {
			dao.insertMember();
		}
	}

}
