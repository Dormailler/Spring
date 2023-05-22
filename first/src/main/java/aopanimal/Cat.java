package aopanimal;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {
	@Override
	public String lunch() {
		System.out.println("사료 먹었습니다.");
		return "Dog-사료";
	}
	
}
