package member.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import member.model.vo.Member;

public class MemberDao2 {

	public MemberDao2() {}
	public Member selectLogin(Connection conn, String userId, String userPwd) {

		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query =  "select * from member "
				+ "where userid = ? and userpwd = ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset=pstmt.executeQuery();
		
			if(rset.next()) {
		
				loginUser = new Member();
				
				loginUser.setUserId(userId);
				loginUser.setUserPwd(userPwd);
				loginUser.setUserName(rset.getString("username"));
				loginUser.setPhone(rset.getString("phone"));
				loginUser.setEmail(rset.getString("email"));
				loginUser.setAge(rset.getInt("age"));
				loginUser.setGender(rset.getString("gender"));

	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return loginUser;
	}
	
	
	//Member 회원가입 시 , 아이디 중복 처리 확인용
	public int selectCheckId(Connection conn, String userId) {
		int result = 0 ;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(userId) from member where userid = ?"; 
								//?안에 들어가는 userId와 같은 것이 member에 몇개(count)인가를 묻는 것.
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				result=rset.getInt(1);
				
			}
			System.out.println("중복처리에 대한 결과 " + result );
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		close(rset);
		close(pstmt);
		}	
		return result;
	}
	
	//Member 회원가입 에서 회원가입 등록에 대한 처리용
	public int insertMember(Connection conn, String userId, String userName, String userPwd,String email, String phone,
			 String age, String gender) {
		int result= 0 ; 
		PreparedStatement pstmt = null;
		
		String query = "insert into member values (?,?,?,?,?,?,?)";
		try {
			pstmt= conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userName);
			pstmt.setString(3, userPwd);
			pstmt.setString(4, email);
			pstmt.setString(5, phone);
			pstmt.setInt(6, Integer.parseInt(age));
			pstmt.setString(7, gender);

			result= pstmt.executeUpdate();
			//return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				
		return result;	
	}
	
	
	//로그인유저가 회원정보를 수정하기위해 비밀번호를 한번 더 입력하도록 하는 처리용 
	public Member modifyUser(Connection conn, String userId , String userPwd) {

		Member modifyUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query =  "select * from member "
				+ "where userid = ? and userpwd = ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset=pstmt.executeQuery();
			/*conn.setAutoCommit(false);*/
			if(rset.next()) {
		
				modifyUser  = new Member();
				
				modifyUser.setUserId(userId);
				modifyUser.setUserPwd(userPwd);
				modifyUser.setUserName(rset.getString("username"));
				modifyUser.setPhone(rset.getString("phone"));
				modifyUser.setEmail(rset.getString("email"));
				modifyUser.setAge(rset.getInt("age"));
				modifyUser.setGender(rset.getString("gender"));

	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
	
		return modifyUser;
	}
	

	
	//아이디 찾을 떄 이름과 이메일로 id를 찾기위함 
	public String findMember(Connection conn, String userName, String email) {
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		  String userId=null ; //찾을아이디


		String query="select userId from MEMBER where userName=? and email=?";

		try{
			   pstmt=conn.prepareStatement(query); //쿼리
			   pstmt.setString(1, userName); //첫번째 ?를 스트링 id로 넣음
			   pstmt.setString(2, email); //두번째 ?에 스트링 pw 넣음
			   
			   rset=pstmt.executeQuery(); //쿼리를 실행해서 결과값을 rs로 저장
			   
			   while(rset.next()){  //rs가 끝날때까지 반복
			    userId=rset.getString("userId"); //cnt를 디비에서 가져온 cnt에 저장  
			  
			   }

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return userId;
	}
	
	//비밀번호 찾을 때 아이디랑 핸드폰번호
	public String findPwdMember(Connection conn, String userId, String phone) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		  String userPwd=null ; //찾을 pwd


		String query="select userPwd from MEMBER where userId=? and phone=?";

		try{
			   pstmt=conn.prepareStatement(query); //쿼리
			   pstmt.setString(1, userId); //첫번째 ?를 스트링 id로 넣음
			   pstmt.setString(2, phone); //두번째 ?에 스트링 pw 넣음
			   
			   rset=pstmt.executeQuery(); //쿼리를 실행해서 결과값을 rs로 저장
			   
			   while(rset.next()){  //rs가 끝날때까지 반복
			    userPwd=rset.getString("userPwd"); //cnt를 디비에서 가져온 cnt에 저장  
			  
			   }

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return userPwd;
	}
	
	
	//회원정보 수정용
	public int modifyDetailMember(Connection conn, Member member) {
		int result = 0;  //result를 기본값 0으로 주고  
		
		PreparedStatement pstmt = null;
		
		//컬럼 순서에 따라 값을 기록해 넣어야한다.
		String query= "update member "
				+ "set username = ?, userpwd = ?, "
				+ "email = ?, phone = ?, age = ?"
				+ "where userid = ?";
				//6개가 바꾸는 항목에 적용됨
				
		try { //안바꾸면 지워버리면 된다.
			pstmt = conn.prepareStatement(query);			
			pstmt.setString(1, member.getUserName());			
			pstmt.setString(2, member.getUserPwd());			
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getPhone());		
			pstmt.setInt(5, member.getAge());	
			pstmt.setString(6, member.getUserId());

			//결과는 정수 result가 받음
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;   //result가 리턴되도록 함.
		
	}
	
	//회원 탈퇴처리용
		public int deleteMember(Connection conn, String userId, String userPwd) {
			int result = 0;
			PreparedStatement pstmt = null;
			
			String query = "delete from member where userid = ? and userpwd =?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userId);
				pstmt.setString(2, userPwd);
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			
			
			return result;
			
			
		}
		public ArrayList<Member> selectMember(Connection conn) {
			ArrayList<Member> mlist = new ArrayList<Member>();
			PreparedStatement pstmt = null;
			Statement stmt = null;
			ResultSet rset = null;
			
			String query = "select * from member";
			
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
				while(rset.next()) {
					Member member = new Member();
					
					member.setAge(rset.getInt("age"));
					member.setEmail(rset.getString("email"));
					member.setGender(rset.getString("gender"));
					member.setPhone(rset.getString("phone"));
					member.setUserId(rset.getString("userid"));
					member.setUserName(rset.getString("username"));
					member.setUserPwd(rset.getString("userpwd"));
					
					/*pstmt.setString(1, member.getUserName());			
					pstmt.setString(2, member.getUserPwd());			
					pstmt.setString(3, member.getEmail());
					pstmt.setString(4, member.getPhone());		
					pstmt.setInt(5, member.getAge());	
					pstmt.setString(6, member.getUserId());*/
					
					mlist.add(member);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				
			}
			
			
			return mlist;
			
			
		}
		public Member selectMember(Connection conn, String fromUserID) {
			Member member = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select * from member where userid=? ";
			
			try {
				
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, fromUserID);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					member = new Member();
					
					member.setAge(rset.getInt("age"));
					member.setEmail(rset.getString("email"));
					member.setGender(rset.getString("gender"));
					member.setPhone(rset.getString("phone"));
					member.setUserId(rset.getString("userid"));
					member.setUserName(rset.getString("username"));
					member.setUserPwd(rset.getString("userpwd"));
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return member;
		}
	
	
	

	
}
