package Match.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Match.vo.MatchMessage;

public class MatchMessageDAO2 {

	public int inserthoogi(Connection conn, MatchMessage matchMessage) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = 
				"insert into matchmessage "
				+ "values(message_seq.nextval, ? , ?, ?, sysdate)";
		
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
	public ArrayList<MatchMessage> select_MatchMessage(Connection conn, int currentPage, int limit) {
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
		
	}



	public ArrayList<MatchMessage> select_MatchMessage(Connection conn, String userID, int currentPage, int limit) {
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
				pstmt.setString(3, userID);
				
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

	

}
