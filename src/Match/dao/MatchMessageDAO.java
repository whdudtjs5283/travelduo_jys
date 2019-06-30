package Match.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Match.vo.MatchMessage;

public class MatchMessageDAO {

	public int inserthoogi(Connection conn, MatchMessage matchMessage) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = 
				"insert into matchmessage "
				+ "values(message_seq.nextval, ? , ?, ?, sysdate, default)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, matchMessage.getFromUser());
			pstmt.setString(2, matchMessage.getToUser());
			pstmt.setString(3, matchMessage.getContent());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	
	
	//단순히 그사람 아이디로 온 총 메세지의 갯수만 구하는 메소드임
	
	public int getListCount(Connection conn, String userID) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = 
				"select count(*) from matchmessage WHERE touser=?";
		
		
		 try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, userID);
	        
	         rset = pstmt.executeQuery();
	            
	         if(rset.next()) {
	        	
	            listCount = rset.getInt(1);
	         }

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
		
	}


//임시//임시//임시//임시//임시//임시//임시//임시//임시
	/*public ArrayList<MatchMessage> xxMatchMessage(Connection conn, int currentPage, int limit) {
		ArrayList<MatchMessage> list = new ArrayList<MatchMessage>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		int replycount = 0;
		
		String query = 
				"select * from(SELECT ROWNUM RNUM,"
						+ " messageno, fromuser, touser, content, messagedate\r\n" + 
						"FROM matchmessage ORDER BY messageno desC)\r\n" + 
						"WHERE (RNUM >= ? AND RNUM <= ?) and touser=? ";
					
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				//pstmt.setString(3, userID);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {	
					MatchMessage Matching = new MatchMessage();
					
					
					Matching.setMessage_No(rset.getInt("messageno"));
					Matching.setContent(rset.getString("content"));
					Matching.setFromUser(rset.getString("fromuser"));
					Matching.setToUser(rset.getString("touser"));
					Matching.setMessageDate(rset.getDate("messagedate"));
				
					list.add(Matching);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
		
		return list;
		
	}*/



	public ArrayList<MatchMessage> select_MatchMessage(Connection conn, String userID, int currentPage, int limit) {
		ArrayList<MatchMessage> list = new ArrayList<MatchMessage>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		//int replycount = 0;
		
		String query = 
		
				
			/*	"select * from " + 
				"(select rownum rnum , messageno, fromuser, touser, content, messagedate " + 
				"from matchmessage " + 
				"where touser=? " + 
				"order by messagedate desc) " + 
				"where rnum >=? and rnum <= ?";*/
		
		//서브쿼리 한번 더 바꿈
				
				"select * from \r\n" + 
				"(select rownum rnum , messageno, fromuser, touser, content, messagedate, messagereadcount\r\n" + 
				"from (select * from matchmessage where touser=? order by messagedate desc))\r\n" + 
				"where rnum >=? and rnum <= ?";
		
	
					
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userID);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {	
					MatchMessage Matching = new MatchMessage();
					
					
					Matching.setMessage_No(rset.getInt("messageno"));
					Matching.setContent(rset.getString("content"));
					Matching.setFromUser(rset.getString("fromuser"));
					Matching.setToUser(rset.getString("touser"));
					Matching.setMessageDate(rset.getDate("messagedate"));
					Matching.setMessagereadcount(rset.getInt("messagereadcount"));
				
					list.add(Matching);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
		
		return list;
		
	}



	
	//쿼리문 수정버전
	public ArrayList<MatchMessage> select_MatchMessage2(Connection conn, String userID, int currentPage, int limit) {
		ArrayList<MatchMessage> list = new ArrayList<MatchMessage>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		
		String query = 
	
		
		//최신글부터 나오게 수정 해봄
	
		"  select * from\r\n" + 
		"      (SELECT ROWNUM RNUM,\r\n" + 
		"      messageno, fromuser, touser, content, messagedate\r\n" + 
		"        FROM matchmessage  where touser=?  ORDER BY messageno desC \r\n" + 
		"       )   WHERE (RNUM >= ?  and rnum <= ((select max(messageno) from matchmessage)) )";
					
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, userID);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {	
					MatchMessage Matching = new MatchMessage();
					
					
					Matching.setMessage_No(rset.getInt("messageno"));
					Matching.setContent(rset.getString("content"));
					Matching.setFromUser(rset.getString("fromuser"));
					Matching.setToUser(rset.getString("touser"));
					Matching.setMessageDate(rset.getDate("messagedate"));
				
					list.add(Matching);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
		
		return list;
		
	}
	
	
	public MatchMessage selectHoogiNo(Connection conn, int messageNo) {
		MatchMessage Message = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from Matchmessage where messageno=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, messageNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				Message = new MatchMessage();
				
				Message.setMessage_No(rset.getInt("messageno"));
				Message.setFromUser(rset.getString("fromuser"));
				Message.setContent(rset.getString("content"));
				Message.setMessageDate(rset.getDate("messagedate"));
				Message.setToUser(rset.getString("touser"));
				Message.setMessagereadcount(rset.getInt("messagereadcount"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return Message;
	}
	
	
	//조회수용인데, 읽음 안읽음을 표시함
	public int addReadCount(Connection conn, int messageNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		
		String query = "update matchmessage set messagereadcount = messagereadcount +1" + 
				"where messageno=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, messageNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	

}
