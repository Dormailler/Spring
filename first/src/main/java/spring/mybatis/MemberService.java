package spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface MemberService {
	public List<MemberDTO> memberList();
	MemberDTO oneMember(String id);
	String registerMember(MemberDTO dto);
	String modifyMember(MemberDTO dto);
	String deleteMember(String id);
	//List<MemberDTO> memberPagingList(int[] limit);
	public List<MemberDTO> memberPagingList(ArrayList limit);
	public List<MemberDTO> searchList(HashMap<String, String> map);
	public List<MemberDTO> searchList2(MemberDTO dto);
	public MemberDTO totalsql(String id);
}
