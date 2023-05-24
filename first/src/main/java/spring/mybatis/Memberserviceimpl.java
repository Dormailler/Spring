package spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Memberserviceimpl implements MemberService {
	MemberDAO dao;
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<MemberDTO> memberList(){
		int count = dao.memberCount();
		List<MemberDTO> list = dao.memberList();
		list.add(new MemberDTO("count",null,count,null,null,null));
		return list;
	}
	
	public MemberDTO oneMember(String id) {
		return dao.oneMember(id);
	}

	@Override
	public String registerMember(MemberDTO dto) {
		MemberDTO mybatis_dto = dao.oneMember(dto.getMemberid());
		
		if(mybatis_dto != null) {
			return "아이디 중복 - 회원가입 불가능합니다.";
		}else {
			dao.insertMember(dto);
			return "정상적으로 회원가입되었습니다.";
		}
	}
	
	public String modifyMember(MemberDTO dto) {
		MemberDTO mybatis_dto = dao.oneMember(dto.getMemberid());
		
		if(mybatis_dto == null) {
			return "수정할 회원 정보가 없습니다.";
		}else {
			dao.updateMember(dto);
			return "정상적으로 수정되었습니다.";
		}
	}

	@Override
	public String deleteMember(String id) {
		MemberDTO mybatis_dto = dao.oneMember(id);
		
		if(mybatis_dto == null) {
			return "삭제할 회원 정보가 없습니다.";
		}else {
			dao.deleteMember(id);
			return "정상적으로 삭제되었습니다.";
		}
	}

	@Override
	//public List<MemberDTO> memberPagingList(int[] limit) {
	public List<MemberDTO> memberPagingList(ArrayList limit) {
		return dao.memberPagingList(limit);
	}

	@Override
	public List<MemberDTO> searchList(HashMap<String, String> map) {
		return dao.searchList(map);
	}
	
	public List<MemberDTO> searchList2(MemberDTO dto){
		return dao.searchList2(dto);
	}
	public MemberDTO totalsql(String id) {
		return dao.totalsql(id);
	}
	
}
