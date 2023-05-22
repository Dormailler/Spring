package memberlist;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//configuration
@Service("list")
public class MemberListService {
	@Autowired
	MemberDAO dao;
	//@Bean
	ArrayList<MemberDTO> getList(int page,int cnt){
		//page = 0 이거나 cnt = 0이면 전체리스트
		//page != 0 , cnt != 0 page=3 cnt =5 (3페이지 5명)
		if(page == 0 | cnt == 0) {
			return dao.getNonPagingMember();
		}else {
			return dao.getPagingMember(page, cnt);
		}
	}
}
