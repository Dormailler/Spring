package spring.mybatis;


import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop1.Member;

public class MybatisMain {

	public static void main(String[] args) throws IOException {
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/mybatis/spring-mybatis.xml");; 
		
		MemberService service =  factory.getBean("memberServiceImpl",MemberService.class);
		
		List<MemberDTO> list = service.memberList();
		for(MemberDTO dto : list) {
			System.out.println(dto.getMemberid() + ":" + dto.getPw() + ":"+ dto.getName() + ":" + dto.getRegtime());
		}
	}

}
