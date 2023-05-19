package memberservice;

public class MemberBasicService implements MemberService {
	MemberDAO dao;
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	MemberBasicService(){
		System.out.println("MemberBasicService 객체생성");
	}
	@Override
	public void registerMember() {
		boolean result = dao.selectMember();
		if(!result) {
			dao.insertMember();
		}

	}

}
