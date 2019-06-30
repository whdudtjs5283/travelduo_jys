package qna.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import qna.model.vo.QNA;

public class QNADao {

		public QNADao() {
		}

		public ArrayList<QNA> selectList(
				Connection conn, int currentPage, int limit) {
			ArrayList<QNA> list = 
					new ArrayList<QNA>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			
			//해당 페이지에 출력할 목록의 시작행과 끝행 계산
					int startRow = (currentPage -1) * limit + 1;
					int endRow = startRow + limit - 1;
					
			String query = "select * from(SELECT ROWNUM RNUM, qna_num, qna_content,qna_title,qna_date,userid,qna_reply,qna_ref from (SELECT * FROM  qna order by qna_ref desc, qna_reply asc, qna_num desc)) WHERE RNUM >= ? AND RNUM <= ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);

				
				
				rset = pstmt.executeQuery();
				
				
				while(rset.next()) {
					QNA qna = new QNA();
					
					qna.setQNANo(rset.getInt("qna_num"));
					qna.setQNATitle(rset.getString("qna_title"));
					qna.setQNADate(rset.getDate("qna_date"));
					qna.setQNAWriter(rset.getString("userid"));
					qna.setQNAContent(rset.getString("qna_content"));
					qna.setQNAReply(rset.getInt("qna_reply"));
					qna.setQNARef(rset.getInt("qna_ref"));
									
					list.add(qna);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}

		public QNA selectOne(Connection conn, int qnaNo) {
			QNA qna = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select * from qna where qna_num = ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, qnaNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					qna = new QNA();
					
					qna.setQNANo(qnaNo);
					qna.setQNATitle(rset.getString("qna_title"));
					qna.setQNADate(rset.getDate("qna_date"));
					qna.setQNAWriter(rset.getString("userid"));
					qna.setQNAContent(rset.getString("qna_content"));
					qna.setQNAReply(rset.getInt("qna_reply"));
					qna.setQNARef(rset.getInt("qna_ref"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return qna;
		}

		public int insertQNA(Connection conn, QNA qna) {
			int result = 0;
			PreparedStatement pstmt = null;
			
			String query = "insert into qna values "
					+ "((select max(qna_num) + 1 from qna),?, ?, sysdate, ?,0,(select max(qna_num) + 1 from qna))";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, qna.getQNAWriter());
				pstmt.setString(2, qna.getQNATitle());
				pstmt.setString(3, qna.getQNAContent());
				
				
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}		
		
			return result;
		}

		public int updateQNA(Connection conn, QNA qna) {
			int result = 0;
			PreparedStatement pstmt = null;
			
			String query = "update qna set qna_title = ?, qna_content = ? where qna_num = ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, qna.getQNATitle());			
				pstmt.setString(2, qna.getQNAContent());
				pstmt.setInt(3, qna.getQNANo());
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		}

		public int deleteQNA(Connection conn, int qnaNo) {
			int result = 0;
			PreparedStatement pstmt = null;
			
			String query = "delete from qna "
					+ "where qna_ref = ?";
			System.out.println("query : " + query);
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, qnaNo);
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		}

		public ArrayList<QNA> selectSearchTitle(Connection conn, String qnaTitle) {
			ArrayList<QNA> list = 
					new ArrayList<QNA>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select * from qna "
					+ "where qna_title like ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%" + qnaTitle + "%");
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					QNA qna = new QNA();
					
					qna.setQNANo(rset.getInt("qna_num"));
					qna.setQNATitle(rset.getString("qna_title"));
					qna.setQNADate(rset.getDate("qna_date"));
					qna.setQNAWriter(rset.getString("userid"));
					qna.setQNAContent(rset.getString("qna_content"));
					qna.setQNAReply(rset.getInt("qna_reply"));
					qna.setQNARef(rset.getInt("qna_ref"));
									
					list.add(qna);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}



		public int getListCount(Connection conn) {
			int listCount = 0;
			Statement stmt = null;
			ResultSet rset = null;
			
			String query = "select count(*) from qna";
			
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
				if(rset.next()) {
					listCount = rset.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(stmt);
			}
			
			return listCount;
		}

		public ArrayList<QNA> selectTitleList(Connection conn, String title, int currentPage, int limit) {
			ArrayList<QNA> list = new ArrayList<QNA>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			//해당 페이지에 출력할 목록의 시작행과 끝행 계산
			int startRow = (currentPage -1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			String query = "SELECT * FROM (SELECT ROWNUM RNUM, qna_num, qna_content, qna_title,qna_date,userid,qna_reply,qna_ref FROM (SELECT * FROM qna where qna_title like ? ORDER BY qna_ref desc, qna_reply asc, qna_num desc)) WHERE RNUM >= ? AND RNUM <= ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%" + title + "%");
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					QNA qna = new QNA();
					
					qna.setQNANo(rset.getInt("qna_num"));
					qna.setQNATitle(rset.getString("qna_title"));
					qna.setQNAWriter(rset.getString("userid"));
					qna.setQNAContent(rset.getString("qna_content"));
					qna.setQNADate(rset.getDate("qna_date"));
					qna.setQNAReply(rset.getInt("qna_reply"));
					qna.setQNARef(rset.getInt("qna_ref"));
					
					list.add(qna);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}

		public QNA selectQNA(Connection conn, int qnaNum) {
			QNA qna = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select * from qna "
					+ "where qna_num = ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, qnaNum);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					qna = new QNA();
					
					qna.setQNANo(rset.getInt("qna_num"));
					qna.setQNATitle(rset.getString("qna_title"));
					qna.setQNAWriter(rset.getString("userid"));
					qna.setQNAContent(rset.getString("qna_content"));
					qna.setQNADate(rset.getDate("qna_date"));
					qna.setQNAReply(rset.getInt("qna_reply"));
					qna.setQNARef(rset.getInt("qna_ref"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return qna;
		}

		public int insertReply(Connection conn, QNA replyQNA) {
			int result = 0;
			PreparedStatement pstmt = null;
			
			String query = null;
			//원글의 댓글일 때
			if(replyQNA.getQNAReply() == 1) {
				query = "insert into qna values "
					+ "((select max(qna_num) + 1 from qna), "
					+ "?, ?,SYSDATE, ?, ?, ?)";
			}
			
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, replyQNA.getQNAWriter());
				pstmt.setString(2, replyQNA.getQNATitle());
				pstmt.setString(3, replyQNA.getQNAContent());
				
				if(replyQNA.getQNAReply() == 1)
					pstmt.setInt(4, replyQNA.getQNAReply());
				
				pstmt.setInt(5, replyQNA.getQNARef());
				
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		}

		public int getTitleListCount(Connection conn, String title) {
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select count(*) from qna where qna_title like ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%" + title + "%");
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

		public int deleteQNAReply(Connection conn, int qnaNo) {
			int result = 0;
			PreparedStatement pstmt = null;
			
			String query = "delete from qna "
					+ "where qna_num = ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, qnaNo);
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		}
	}