package spring.tv;

public class SamsungTV implements TV{
	public void powerOn(){
		System.out.println("삼성티비 전원켜다");
	}
	public void powerOff() {
		System.out.println("삼성티비 전원끄다");
	}
	public void soundUp() {
		System.out.println("삼성티비 소리높이다");
	}
	public void soundDown() {
		System.out.println("삼성티비 소리낮추다");
	}
	//
}
