package annotation.memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/memberservice/member.xml");
		
		MemberService service = factory.getBean("janservice",MemberService.class);
		
		service.registerMember();
	}
	

}
