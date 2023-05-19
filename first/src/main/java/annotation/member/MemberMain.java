package annotation.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MemberMain {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/member/member.xml");
		
		MemberDAO dao = (MemberDAO)factory.getBean("memberDAO");
		
		/*
		 * String[] beannames = factory.getBeanDefinitionNames(); for(String one :
		 * beannames) { System.out.println(one); }
		 */
		
		boolean result = dao.selectMember();
		
		if(result == true) {
			System.out.println(dao.dto.getMemberid() +"님 정상 로그인 사용자입니다."); 
		}else {
			dao.insertMember(); 
		}
		 
	}
}
