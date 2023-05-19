package tv;

public class TVMain {
	public static void main(String args[]) {
		TV tv = new TVFactory().getTV(args[0]);
		System.out.println(args[0]);
		System.out.println(tv);
		if(tv != null) {
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		}
	System.out.println(11);
	}
	
}
/*
 * 1> 2개객체 모두 동일 TV 메소드 가져야 한다
 * 2> TVFactory 통해서만 생성한다.
 * 3> tv객체 생성 주도권 TVFactory이다.
 * 4> 
 */ 
