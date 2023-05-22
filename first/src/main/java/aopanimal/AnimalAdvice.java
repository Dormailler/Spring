package aopanimal;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnimalAdvice {
	@Pointcut("execution(* aopanimal..*.lunch(..))")
	public void pc() {}
	
	@Around("pc()")
	public void reply(ProceedingJoinPoint join) {	
		try {
			System.out.println("오늘은 뭐 먹을거에요?");
			Object obj = join.proceed();
			System.out.println(obj + " 먹었습니다.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
}
