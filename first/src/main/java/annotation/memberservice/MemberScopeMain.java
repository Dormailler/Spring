package annotation.memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberScopeMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("member/member.xml");
		
		String[] beannames = factory.getBeanDefinitionNames();
		for(String one : beannames) {
			System.out.println(one);
		}
		
		//MemberDTO dto1 = (MemberDTO)factory.getBean("dto")과 동일;
		MemberDTO dto1 = factory.getBean("dto",MemberDTO.class);
		MemberDTO dto2 = factory.getBean("dto",MemberDTO.class);
		MemberDTO dto3 = factory.getBean("dto",MemberDTO.class);
		MemberDTO dto4 = factory.getBean("dto",MemberDTO.class);
		MemberDTO dto5 = factory.getBean("dto",MemberDTO.class);
	}

}
