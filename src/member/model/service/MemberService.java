package member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import static common.JDBCTemplate.*;

public class MemberService {
	private MemberDao mdao = new MemberDao();
	
	public MemberService() {}

	public Member selectLogin(String userId, String userPwd) {
		Connection conn=getConnection();
		Member loginUser = mdao.selectLogin(conn,userId,userPwd);
		close(conn);
		return loginUser;
	}
	
	
		//Member 회원가입 시 , 아이디 중복 처리 확인용
	public int selectCheckId(String userId) {
		Connection conn= getConnection();
		int result = mdao.selectCheckId(conn,userId);
		close(conn);
		return result;
	
		
		
		
	}
		//Member 회원가입 에서 회원가입 등록에 대한 처리용
	public int insertMember(String userId, String userName, String userPwd, String email,
			String phone, String age ,String gender ) {
		Connection conn=getConnection();
		int result=mdao.insertMember(conn,userId,userName ,userPwd,email , phone, age, gender);  //원래는userid ,userpwd username~~~다 써줘야하지만 member안에다가 담아줬기 때문에 member만 써도 된다.
		if(result >0) 
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}

	
	//로그인유저가 회원정보를 수정하기위해 비밀번호를 한번 더 입력하도록 하는 처리용 
	public Member modifyUser(String userId, String userPwd) {
		Connection conn=getConnection();
		Member modifyUser=mdao.modifyUser(conn,userId,userPwd);
		close(conn);
		return modifyUser;
	}

	//아이디 찾을 떄 이름과 이메일로 id를 찾기위함 
	public String findMember(String userName, String email) {
		Connection conn= getConnection();
		String userId = mdao.findMember(conn, userName, email);
		close(conn);
		return userId;
	
	}
	//비밀번호 찾을 때 아이디랑 핸드폰번화
	public String findPwdMember(String userId, String phone) {
		Connection conn =getConnection();
		String userPwd = mdao.findPwdMember(conn , userId , phone);
		close(conn);
		return userPwd;
			
		
	}

	//회원정보 수정용
	public int modifyDetailMember(Member member) {
			Connection conn = getConnection();
			int result = mdao.modifyDetailMember(conn, member);  //insertMember 만들어줌 
			if(result > 0)
				//성공한것임
				commit(conn);
			else  //성공못한것임
				rollback(conn);
			close(conn);   //import static common.JDBCTemplate.close; 를 import static common.JDBCTemplate.*; 바꾸면 오류없어짐
			return result;
			
		}
		//회원탙퇴 처리용
	public int deleteMember(String userId , String userPwd) {
			Connection conn = getConnection();
			int result = mdao.deleteMember(conn, userId, userPwd);   //.deletemeber는 memberdao로 보냇음
			if(result >0)
				commit(conn);
			else
				rollback(conn);
			close(conn);
			return result;
			
			
			
	
	}

	public Object selectModifyMember(String userId) {
		Connection conn=getConnection();
		Member member = mdao.selectModifyMember(conn,userId);
		close(conn);
		return member;
	
	}
	
	public ArrayList<Member> selectMember() {
		Connection conn = getConnection();
		ArrayList<Member> mlist = mdao.selectMember(conn);
		close(conn);
		return mlist;
	}

	public Member selectMember(String fromUserID) {
		Connection conn = getConnection();
		Member member = mdao.selectMember(conn, fromUserID);
		close(conn);
		return member;
	}




	
	
}
