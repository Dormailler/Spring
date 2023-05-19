package annotation.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository // memberDAO 이름 bean 기본
public class MemberDAO {
	//memberDTO 타입 생선 객체 자동 setter 
	@Autowired //1개면 자동주입 여러개면 @Qualifier
	@Qualifier("dto2")
	MemberDTO dto;
	
	/*
	 * public void setDto(MemberDTO dto) { this.dto = dto; }
	 */

	public boolean selectMember() {
		if(dto.getMemberid().equals("spring") && dto.getPw() == 1111){
			return true;
		}else {
			return false;
		}
	}
	
	public void insertMember() {
		System.out.println(dto.getMemberid() + "회원님 정상적으로 회원가입되셨습니다.");
	}
}
