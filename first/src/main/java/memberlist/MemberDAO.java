package memberlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	// 가입메소드
//	public void insertMember(MemberDTO dto){
//		Connection con = null;
//		try {
//		//Class.forName(DBInfo.driver);
//		//con = DriverManager.getConnection(DBInfo.url, DBInfo.account, DBInfo.password);
//		//System.out.println("연결성공");
//		Context context = new InitialContext(); //context.xml 설정내용 객체
//		Context envContext = (Context)context.lookup("java:/comp/env"); //자바연관설정 찾기
//		DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
//		con = ds.getConnection();
//		
//		String sql = "insert into c_member values( ?,?,?,?,?,default)";
//		PreparedStatement pt = con.prepareStatement(sql); 
//		pt.setString (1, dto.getMemberid());//아이디
//		pt.setString(2, dto.getName());//이름
//		pt.setInt(3, dto.getPw());// 암호만 int
//		pt.setString (4, dto.getPhone());//폰
//		pt.setString (5, dto.getEmail());//이메일
//		
//		int rowcount = pt.executeUpdate();
//		System.out.println("회원가입행 갯수 = " +rowcount);//1
//		
//		//con.close();//파일close,소켓close
//		}catch(SQLException e){
//			e.printStackTrace();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				con.close();// 반납
//			}catch(SQLException e) {}
//			System.out.println("연결해제성공");
//		}
//		
//	}
	
	// 수정메소드
	public int updateMember(MemberDTO dto){//memberid, pw~email
		Connection con = null;
		int result = 0; 
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection(DBInfo.url, DBInfo.account, DBInfo.password);
		//System.out.println("연결성공");
		String colName = "";
		String colValue = "";
		if(dto.getPw() != 0) {
			colName="pw";
			colValue = String.valueOf(dto.getPw()) ;
		}
		else if(dto.getName() != null) {
			colName="name";
			colValue = dto.getName();
		} 
		else if(dto.getPhone() != null) {
			colName="phone";
			colValue = dto.getPhone();
		}
		else if(dto.getEmail() != null) {
			colName="email";
			colValue = dto.getEmail();
		}
		String sql = "update c_member set " + colName +"=? where memberid=?";
		PreparedStatement pt = con.prepareStatement(sql); 
		pt.setString (1, colValue);
		pt.setString(2, dto.getMemberid());
		result = pt.executeUpdate();
		//System.out.println("회원가입행 갯수 = " +rowcount);//1
		
		//con.close();//파일close,소켓close
		//System.out.println("연결해제성공");
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 등록 여부를 확인하세요");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();//파일close,소켓close
			}catch(SQLException e) {}
			System.out.println("연결해제성공");
		}
		return result;
	}//updateMember end

	//userupdate 메소드
	public int updateMember_jsp(MemberDTO dto){//memberid, pw~email
		Connection con = null;
		int result = 0; 
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection(DBInfo.url, DBInfo.account, DBInfo.password);
		//System.out.println("연결성공");
		String sql = "update c_member set name=?, email=?,phone=? "
				+ "where memberid=? and pw=?";
		PreparedStatement pt = con.prepareStatement(sql); 
		pt.setString (1, dto.getName());
		pt.setString(2, dto.getEmail());
		pt.setString(3, dto.getPhone());
		pt.setString(4, dto.getMemberid());
		pt.setInt(5, dto.getPw());
		result = pt.executeUpdate();
		//System.out.println("회원가입행 갯수 = " +rowcount);//1
		
		//con.close();//파일close,소켓close
		//System.out.println("연결해제성공");
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 등록 여부를 확인하세요");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();//파일close,소켓close
			}catch(SQLException e) {}
			System.out.println("연결해제성공");
		}
		return result;
	}//updateMember end

	// 내정보조회메소드
//	public MemberDTO getMember(String memberid, int pw){
//		MemberDTO dto = null;
//		Connection con = null;
//		try {
//		Class.forName(DBInfo.driver);
//		con = DriverManager.getConnection(DBInfo.url, DBInfo.account, DBInfo.password);
//		//System.out.println("연결성공");
//		
//		String sql = "select memberid, name, pw, phone, email, date(regtime) from c_member where memberid=?";
//		PreparedStatement pt = con.prepareStatement(sql); 
//		pt.setString (1, memberid);//아이디
//		ResultSet rs = pt.executeQuery();
//		if(rs.next()) {
//			if(pw == rs.getInt("pw")) {
//				dto = new MemberDTO(
//				(rs.getString("memberid") , rs.getString("name") ,
//				rs.getInt("pw"), rs.getString("phone"),
//				rs.getString("email") , rs.getString("date(regtime)") ); 
//			}
//			else {//암호가 다르다
//				dto = new MemberDTO();
//				dto.setMemberid(memberid);
//				//dto.getMemberid() != null dto.getPw() --> 0
//			}
//		} //true
//		else { //해당아이디 없다
//			dto = new MemberDTO(); //dto.getMemberid() --> null
//		}
//		//con.close();//파일close,소켓close
//		//System.out.println("연결해제성공");
//		}
//		catch(ClassNotFoundException e) {
//			System.out.println("드라이버 등록 여부를 확인하세요");
//		}
//		catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				con.close();//파일close,소켓close
//			}catch(SQLException e) {}
//			System.out.println("연결해제성공");
//		}
//		return dto;
//	}//getMember end

	// 탈퇴메소드
	public int deleteMember(String memberid, int pw){
		int result = 0;
		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection(DBInfo.url, DBInfo.account, DBInfo.password);
		//System.out.println("연결성공");
		
		String sql = "select pw from c_member where memberid=?";
		PreparedStatement pt = con.prepareStatement(sql); 
		pt.setString (1, memberid);
		ResultSet rs = pt.executeQuery();
		if(rs.next()) {//삭제아이디 존재
			if(pw == rs.getInt("pw")) {
				sql = "delete from c_member where memberid=?";
				pt = con.prepareStatement(sql); 
				pt.setString (1, memberid);
				int row = pt.executeUpdate();
			}
			else {//암호가 다르다
				result = 1;
			}
		} 
		else { //해당아이디 없다
			result = 2;
		}
		//con.close();//파일close,소켓close
		//System.out.println("연결해제성공");
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 등록 여부를 확인하세요");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();//파일close,소켓close
			}catch(SQLException e) {}
			System.out.println("연결해제성공");
		}
		return result;
	}//deleteMember end

	// 회원수조회메소드
	public int getTotalMember(){
		int total = 0;
		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection(DBInfo.url, DBInfo.account, DBInfo.password);
		//System.out.println("연결성공");
		
		String sql = "select count(*) as cnt from c_member";
		PreparedStatement pt = con.prepareStatement(sql); 
		ResultSet rs = pt.executeQuery();
		rs.next();
		total = rs.getInt("cnt");
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 등록 여부를 확인하세요");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();//파일close,소켓close
			}catch(SQLException e) {}
			System.out.println("연결해제성공");
		}
		return total;
	}//getTotalMember end
	
	// 페이지처리된 회원리스트 조회메소드
	public ArrayList<MemberDTO> getPagingMember(int pagenum, int cnt){
		ArrayList<MemberDTO> list = new ArrayList();
		
		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection(DBInfo.url, DBInfo.account, DBInfo.password);
		//System.out.println("연결성공");
		
		String sql = "select memberid, name, regtime from c_member order by regtime desc limit ? , ?";
		PreparedStatement pt = con.prepareStatement(sql); 
		pt.setInt(1, (pagenum-1)*cnt );
		pt.setInt(2, cnt);
		ResultSet rs = pt.executeQuery();
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setMemberid(rs.getString("memberid"));
			dto.setName(rs.getString("name"));
			dto.setRegtime(rs.getString("regtime"));
			list.add(dto);
		}

		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 등록 여부를 확인하세요");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();//파일close,소켓close
			}catch(SQLException e) {}
			System.out.println("연결해제성공");
		}
		return list;
	}//getPagingMember end
	
	public ArrayList<MemberDTO> getNonPagingMember(){
		ArrayList<MemberDTO> list = new ArrayList();
		
		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection(DBInfo.url, DBInfo.account, DBInfo.password);
		//System.out.println("연결성공");
		
		String sql = "select * from c_member order by regtime desc";
		PreparedStatement pt = con.prepareStatement(sql); 
		ResultSet rs = pt.executeQuery();
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setMemberid(rs.getString("memberid"));
			dto.setName(rs.getString("name"));
			dto.setEmail(rs.getString("email"));
			dto.setPhone(rs.getString("phone"));
			dto.setRegtime(rs.getString("regtime"));
			list.add(dto);
		}

		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 등록 여부를 확인하세요");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();//파일close,소켓close
			}catch(SQLException e) {}
			System.out.println("연결해제성공");
		}
		return list;
	}//getPagingMember end
	
}//claa end
