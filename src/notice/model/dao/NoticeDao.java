package notice.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import notice.model.vo.Notice;

public class NoticeDao {
	public NoticeDao() {
	}

	public ArrayList<Notice> selectList(
			Connection conn, int currentPage, int limit) {
		ArrayList<Notice> list = 
				new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		//해당 페이지에 출력할 목록의 시작행과 끝행 계산
				int startRow = (currentPage -1) * limit + 1;
				int endRow = startRow + limit - 1;
				
		String query = "select * from(SELECT ROWNUM RNUM, noticeno, noticecontent,noticetitle,noticedate,noticewriter from (SELECT * FROM  notice order by noticeno desc)) WHERE RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt("noticeno"));
				notice.setNoticeTitle(rset.getString("noticetitle"));
				notice.setNoticeDate(rset.getDate("noticedate"));
				notice.setNoticeWriter(rset.getString("noticewriter"));
				notice.setNoticeContent(rset.getString("noticecontent"));
								
				list.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public Notice selectOne(Connection conn, int noticeNo) {
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from notice where noticeno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				
				notice.setNoticeNo(noticeNo);
				notice.setNoticeTitle(rset.getString("noticetitle"));
				notice.setNoticeDate(rset.getDate("noticedate"));
				notice.setNoticeWriter(rset.getString("noticewriter"));
				notice.setNoticeContent(rset.getString("noticecontent"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return notice;
	}

	public int insertNotice(Connection conn, Notice notice) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into notice values "
				+ "((select max(noticeno) + 1 from notice),?, ?, sysdate, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeContent());
			pstmt.setString(2, notice.getNoticeTitle());
			pstmt.setString(3, notice.getNoticeWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
	
		return result;
	}

	public int updateNotice(Connection conn, Notice notice) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update notice set noticetitle = ?, noticecontent = ? where noticeno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeTitle());			
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setInt(3, notice.getNoticeNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteNotice(Connection conn, int noticeNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from notice "
				+ "where noticeno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Notice> selectSearchTitle(Connection conn, String noticeTitle) {
		ArrayList<Notice> list = 
				new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from notice "
				+ "where noticetitle like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + noticeTitle + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt("noticeno"));
				notice.setNoticeTitle(rset.getString("noticetitle"));
				notice.setNoticeDate(rset.getDate("noticedate"));
				notice.setNoticeWriter(rset.getString("noticewriter"));
				notice.setNoticeContent(rset.getString("noticecontent"));
								
				list.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public ArrayList<Notice> selectTop5Write(Connection conn) {
			ArrayList<Notice> list = new ArrayList<Notice>();
			Statement stmt = null;
			ResultSet rset = null;
			
			String query = "SELECT * " + 
					"FROM (SELECT ROWNUM RNUM, NOTICENO, NOTICETITLE, " + 
					"NOTICEDATE " + 
					"FROM (SELECT * FROM NOTICE " + 
					"ORDER BY NOTICEDATE DESC)) " + 
					"WHERE RNUM >= 1 AND RNUM <= 5";
			
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
				while(rset.next()) {
					Notice notice = new Notice();
					
					notice.setNoticeNo(rset.getInt("noticeno"));
					notice.setNoticeTitle(rset.getString("noticetitle"));
					notice.setNoticeDate(rset.getDate("noticedate"));
					
					list.add(notice);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(stmt);
			}
			
			return list;
	}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from notice";
		
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

	public ArrayList<Notice> selectTitleList(Connection conn, String title, int currentPage, int limit) {
		ArrayList<Notice> list = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//해당 페이지에 출력할 목록의 시작행과 끝행 계산
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String query = "SELECT * FROM (SELECT ROWNUM RNUM, noticeno, noticecontent, noticetitle,noticedate,noticewriter FROM (SELECT * FROM notice where noticetitle like ? ORDER BY noticeno desc)) WHERE RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + title + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt("noticeno"));
				notice.setNoticeTitle(rset.getString("noticetitle"));
				notice.setNoticeWriter(rset.getString("noticewriter"));
				notice.setNoticeContent(rset.getString("noticecontent"));
				notice.setNoticeDate(rset.getDate("noticedate"));
				
				list.add(notice);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int getTitleListCount(Connection conn, String title) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from notice where noticetitle like ?";
		
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
}









