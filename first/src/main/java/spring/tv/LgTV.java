package spring.tv;

public class LgTV implements TV{
	public void powerOn() {
		System.out.println("엘지티비 전원켜다");
	}
	public void powerOff() {
		System.out.println("엘지티비 전원끄다");
	}
	public void soundUp() {
		System.out.println("엘지티비 볼륨높이다");
	}
	public void soundDown() {
		System.out.println("엘지티비 볼륨낮추다");
	}
}
