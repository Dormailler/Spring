package aop1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

public class Common {
	long starttime = System.currentTimeMillis();
	public void a() { //target 실행이전 자동 실행 xml 설정
		System.out.println(new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초").format(new Date(starttime)));
	}
	public void b() { //target 실행후 자동 실행 xml 설정
		
		long endtime = System.currentTimeMillis();
		System.out.println("메소드수행시간(1/1000 초)="+ (endtime-starttime));
	}
	public void c(ProceedingJoinPoint joinpoint) {	
		try {
			System.out.println("메소드수행 이전입니다.");
			// 현재 target 메소드 실행명령
			Object obj = joinpoint.proceed();
			if(obj != null) System.out.println("target 메소드 리턴값 = " + obj);
			System.out.println("클래스이름 = " + joinpoint.getTarget());
			System.out.println("메소드이름 = " + joinpoint.toShortString());
			
			Object [] args = joinpoint.getArgs();
			for(Object o : args) {
				System.out.println("메소드매개변수 = " + o);
			}
			System.out.println("메소드수행 이후입니다.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
