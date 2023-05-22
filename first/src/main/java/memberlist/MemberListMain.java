package memberlist;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "memberlist")
public class MemberListMain {

	public static void main(String[] args) {
		// xml 설정 없이 자바 annotation만 사용
		// MemberDAO getNonPagingList 결과 콘솔 출력
		ApplicationContext factory = new AnnotationConfigApplicationContext(MemberListMain.class);
		ArrayList<MemberDTO> list = factory.getBean("list",MemberListService.class).getList(1,5);
		for(MemberDTO dto : list) {
			System.out.println(dto);
		}
	}

}
