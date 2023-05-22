package myconfig;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import member.MemberDTO;

//xml 파일 대신
@Configuration
@ComponentScan(basePackages = "command")
@ComponentScan(basePackages = "myconfig")
public class MyConfig {
	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(MyConfig.class);
		String[] names = factory.getBeanDefinitionNames();
		for(String one: names) {
			System.out.println(one);
		}
		ArrayList<Integer> list = factory.getBean("getList",ArrayList.class);
		for(Integer i:list) {
			System.out.println(i);
		}
	}
	@Bean // 메소드 리턴객체 bean 이름("getList")
	ArrayList getList(){
		ArrayList<Integer> list = new ArrayList();
		list.add(100);
		list.add(200);
		list.add(300);
		return list;
	}
}
