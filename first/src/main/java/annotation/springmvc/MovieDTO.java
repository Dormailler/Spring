package annotation.springmvc;

public class MovieDTO {
	String memberid;
	int pw,age;
	String[] mymovielist;
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String[] getMymovielist() {
		return mymovielist;
	}
	public void setMymovielist(String[] mymovielist) {
		this.mymovielist = mymovielist;
	}
	
}
