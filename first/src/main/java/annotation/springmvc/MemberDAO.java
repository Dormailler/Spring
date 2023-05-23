package annotation.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	public boolean selectMember(MemberDTO dto) {
		if(dto.getMemberid().equals("spring")){
			return true;
		}else {
			return false;
		}
	}
	
	public void insertMember(MemberDTO dto) {
		System.out.println(dto.getMemberid() + "회원님 정상적으로 회원가입되셨습니다.");
	}
}
