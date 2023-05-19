package annotation.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("janservice")
public class MemberJanService implements MemberService {
	@Autowired
	MemberDAO dao;
	@Autowired
	PointDAO dao2;
	
	/*
	 * public void setDao(MemberDAO dao) { this.dao = dao; } public void
	 * setDao2(PointDAO dao) { this.dao2 = dao; }
	 */
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
