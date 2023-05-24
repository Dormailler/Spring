package spring.mybatis;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisMain2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory =  builder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));
		SqlSession session = factory.openSession(true); // true auto commit
		
		MemberDAO dao = new MemberDAO();
		dao.setSession(session);
		
		MemberService service = new Memberserviceimpl();
		((Memberserviceimpl)service).setDao(dao);
		
//		List<MemberDTO> list = service.memberList();
//		System.out.println("총회원수 = " + list.get(list.size()-1).pw);
//		
//		for(int i = 0; i < list.size()-1; i++) {
//			System.out.println(list.get(i));
//		}
//		MemberDTO dto = service.oneMember("jdbc2");
//		System.out.println("나의정보 = " + dto);
		
//		MemberDTO dto = new MemberDTO();
//		dto.setMemberid("mybatis3");
//		dto.setName("박진주");
//		dto.setPw(3333);
//		dto.setPhone("010-3333-3335");
//		dto.setEmail("jin@ju.com");
//		String result = service.registerMember(dto);
//		System.out.println(result);
		/*1.memberid 해당 회원정보 MemberDTO 리턴받는다 
		 * 2.리턴받는 정보가 있다 - 아이디 중복 - 회원가입 불가능합니다.
		 * 3. 정보x - 정상적으로 회원가입되었습니다.
		 */
		
		/*MemberDTO dto = new MemberDTO();
		dto.setMemberid("mybatis5");
		dto.setName("박진주");
		dto.setPw(4444);
		dto.setPhone("010-3333-3335");
		dto.setEmail("jin@ju.com");
		String result = service.modifyMember(dto);
		System.out.println(result);*/
		
//		String result = service.deleteMember("mybatis4");
//		System.out.println(result);
		
		//페이지번호 : 1 
		//목록갯수 : 5 
		/*int [] mypage = {0,5};
		ArrayList<Integer> mypage2 = new ArrayList();
		mypage2.add(0);
		mypage2.add(5);
		List<MemberDTO> list = service.memberPagingList(mypage2);
		for(MemberDTO dto : list) {
			System.out.println(dto);
		}*/
		//1월 가입자 조회
		/*HashMap<String, String> map = new HashMap();
		//		map.put("colname", "name");
		//		map.put("colvalue", "%길동%");
		map.put("colname", "regtime");
		map.put("colvalue", "%-03-%"); // ____03%
		
		List<MemberDTO> list = service.searchList(map);
		for(MemberDTO dto : list) {
			System.out.println(dto);
		}*/
		
		/*MemberDTO searchDTO = new MemberDTO("s",null, 1111, null, null, null);
		List<MemberDTO> list = service.searchList2(searchDTO);
		for(MemberDTO dto : list) {
			System.out.println(dto);
		}*/
		
//		MemberDTO dto = service.totalsql("servlet");
//		System.out.println(dto);
		
		
	}
}
