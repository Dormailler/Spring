package myconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//xml 파일 대신
@Configuration
@ComponentScan("command2")
public class MyConfig {

	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext();

	}

}
