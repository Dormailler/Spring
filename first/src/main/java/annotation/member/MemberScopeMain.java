package annotation.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberScopeMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/member/member.xml");
		
		String[] beannames = factory.getBeanDefinitionNames();
		for(String one : beannames) {
			System.out.println(one);
		}
	}

}
