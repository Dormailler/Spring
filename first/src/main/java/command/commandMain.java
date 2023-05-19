package command;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class commandMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("command/command.xml");
//		Command boardservice = factory.getBean("boardservice",Command.class);
//		Command memberservice = factory.getBean("memberservice",Command.class);
//		Command productservice = factory.getBean("productservice",Command.class);
		Command[] mycommand = new Command[3];
		mycommand[0] = factory.getBean("board",Command.class);
		mycommand[1] = factory.getBean("member",Command.class);
		mycommand[2] = factory.getBean("product",Command.class);
		
		for(Command com : mycommand) {
			String result = com.run();
			System.out.println(result);
		}
//		System.out.println(boardservice.run());
//		System.out.println(memberservice.run());
//		System.out.println(productservice.run());

//		BoardCommand bc = factory.getBean("board",BoardCommand.class);
//		bc.insertBoard();
		
	}
	

}
