package memberservice;

public class MemberJanService implements MemberService {
	MemberDAO dao;
	PointDAO dao2;
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	public void setDao2(PointDAO dao) {
		this.dao2 = dao;
	}
	MemberJanService(){
		System.out.println("MemberJanService 객체생성");
	}
	@Override
	public void registerMember() {
		boolean result = dao.selectMember();
		if(!result) {
			dao.insertMember();
			//dao2.setPoint(1000);
			System.out.println(dao2.getPoint() + " 포인트를 받았습니다");
		}

	}

}
