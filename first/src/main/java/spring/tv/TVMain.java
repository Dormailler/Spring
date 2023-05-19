package spring.tv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {
	public static void main(String args[]) {
		//spring에게 tv.xml 설정에 있는 객체 생성 요청
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/tv/tv.xml");
		TV tv = (TV)factory.getBean("tv");
		if(tv != null) {
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		}
	}
	
}
/*
 * 1> 2개객체 모두 동일 TV 메소드 가져야 한다
 * 2> TVFactory 통해서만 생성한다.
 * 3> tv객체 생성 주도권 TVFactory이다.
 * 4> 
 */ 
