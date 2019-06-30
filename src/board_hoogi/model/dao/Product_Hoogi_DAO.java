package board_hoogi.model.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import board_hoogi.model.vo.Product_Hoogi;

public class Product_Hoogi_DAO {
	
	public Product_Hoogi_DAO() {}

	
	
	//
	public ArrayList<Product_Hoogi> select_Hoogi(Connection conn, int currentPage, int limit) {
		
		
		ArrayList<Product_Hoogi> list = new ArrayList<Product_Hoogi>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		int replycount = 0;
		
		
		String query = 
			"SELECT * FROM (SELECT ROWNUM RNUM, BOARD_NUM, userid, btitle, bcontent, board_date, product_num,  \r\n" + 
			"boardOriginalFileName, boardRenameFileName, hoogireadcount,\r\n" + 
			"(select count(*)  from hcomment a where a.board_num=c.board_num ) Ccount, commentcount from \r\n" + 
			"(SELECT * FROM product_hoogi ORDER BY board_num desC) c)\r\n" + 
			"WHERE RNUM >= ? AND RNUM <= ?";
				
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {	
				Product_Hoogi Phoogi = new Product_Hoogi();
				
				Phoogi.setBoardnum(rset.getInt("board_num"));
				Phoogi.setUserid(rset.getString("userid"));
				Phoogi.setBtitle(rset.getString("btitle"));
				Phoogi.setBcontent(rset.getString("bcontent"));
				Phoogi.setBoarddate(rset.getDate("board_date"));
				Phoogi.setProductnum(rset.getString("product_num"));
				Phoogi.setBoardOriginalFileName(rset.getString("boardOriginalFileName"));
				Phoogi.setBoardRenameFileName(rset.getString("boardRenameFileName"));
				Phoogi.setHoogireadcount(rset.getInt("hoogireadcount"));
				//replycount = rset.getInt("Ccount");
				Phoogi.setCommentcount(rset.getInt("Ccount"));
			//	BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				
				list.add(Phoogi);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}


	public int inserthoogi(Connection conn, Product_Hoogi phoogi) {
		int result = 0;
		PreparedStatement pstmt = null;
		
	
		String query =
				"insert into Product_Hoogi \r\n" 
						+ "values(hoogi_seq.nextval, ?, ?, ?, "
						+ "sysdate, '제품번호임의', ?, ?, default, default)";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			//pstmt.setInt(1, phoogi.getBoardnum());
			
			//
			pstmt.setString(1, phoogi.getUserid());
			pstmt.setString(2, phoogi.getBtitle());
			pstmt.setString(3,  phoogi.getBcontent());
			pstmt.setString(4, phoogi.getBoardOriginalFileName());
			pstmt.setString(5, phoogi.getBoardRenameFileName());
			//pstmt.setDate(5, phoogi.getBoarddate());
			//pstmt.setString(6, phoogi.getProductnum());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
	
		return result;
	}

	
	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from product_Hoogi";
		
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
	
	public int getAllCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM "
				+ "(SELECT ROWNUM RNUM, BOARD_NUM, userid, btitle, "
				+ "bcontent, board_date, product_num,  \r\n" 
				+ "boardOriginalFileName, boardRenameFileName, "
				+ "hoogireadcount, \r\n" 
				+ "(select count(*)  from hcomment a where a.board_num=c.board_num ) "
				+ "replycount from \r\n" 
				+ "(SELECT * FROM product_hoogi ORDER BY board_num desC) c)\r\n" 
				+ "WHERE RNUM >= 1 AND RNUM <= 10 ;";
		
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

	

	
	//-> 게시글 번호로 한개 게시글 추출하는 메소드
	public Product_Hoogi selectHoogiNo(Connection conn, int HoogiNo) {
		
	Product_Hoogi Phoogi = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	String query = "select * from Product_Hoogi where board_num = ?";
	
	try {
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, HoogiNo);
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			Phoogi = new Product_Hoogi();
			
			Phoogi.setBoardnum(rset.getInt("board_num"));
			Phoogi.setUserid(rset.getString("userid"));
			Phoogi.setBtitle(rset.getString("btitle"));
			Phoogi.setBcontent(rset.getString("bcontent"));
			Phoogi.setBoarddate(rset.getDate("board_date"));
			Phoogi.setProductnum(rset.getString("product_num"));
			Phoogi.setBoardOriginalFileName(rset.getString("boardOriginalFileName"));
			Phoogi.setBoardRenameFileName(rset.getString("boardRenameFileName"));
			Phoogi.setHoogireadcount(rset.getInt("HOOGIREADCOUNT"));
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		close(rset);
		close(pstmt);
	}
	
	return Phoogi;
		
	}

	

	public int addReadCount(Connection conn, int hoogiNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		///쿼리문 써야됨
		//조회수 디폴트 0으로함
		
		String query = "update product_hoogi set hoogireadcount = hoogireadcount +1" + 
				"where board_num=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, hoogiNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateHoogi(Connection conn, Product_Hoogi phoogi) {
		int result=0;
		PreparedStatement pstmt = null;
		
		String query = 
				"update product_hoogi "
				+ "set btitle=?, "
				+ "bcontent=?, "
				+ "BOARDORIGINALFILENAME=?, "
				+ "BoardRenameFileName=? "
				+ "where board_num=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, phoogi.getBtitle());
			pstmt.setString(2, phoogi.getBcontent());
			pstmt.setString(3, phoogi.getBoardOriginalFileName());
			pstmt.setString(4, phoogi.getBoardRenameFileName());
			pstmt.setInt(5, phoogi.getBoardnum());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}

	public int deleteHoogi(Connection conn, int hoogiNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from Product_Hoogi "
				+ "where board_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);				
			pstmt.setInt(1, hoogiNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	public ArrayList<Product_Hoogi> hoogiSearchTitle(Connection conn, String word, int currentPage, int limit) {
		ArrayList<Product_Hoogi> list = new ArrayList<Product_Hoogi>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String query = 
				
		"SELECT * FROM (SELECT ROWNUM RNUM, BOARD_NUM, userid, btitle, bcontent, board_date, product_num, " + 
		"boardOriginalFileName, boardRenameFileName, hoogireadcount," + 
		"(select count(*)  from hcomment a where a.board_num=c.board_num ) Ccount, commentcount from" + 
		"(SELECT * FROM product_hoogi where btitle like ? " +
		"ORDER BY board_num desC) c)" + 
		"WHERE RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + word + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product_Hoogi Phoogi = new Product_Hoogi();
				
				Phoogi.setBoardnum(rset.getInt("board_num"));
				Phoogi.setUserid(rset.getString("userid"));
				Phoogi.setBtitle(rset.getString("btitle"));
				Phoogi.setBcontent(rset.getString("bcontent"));
				Phoogi.setBoarddate(rset.getDate("board_date"));
				Phoogi.setProductnum(rset.getString("product_num"));
				Phoogi.setBoardOriginalFileName(rset.getString("boardOriginalFileName"));
				Phoogi.setBoardRenameFileName(rset.getString("boardRenameFileName"));
				Phoogi.setCommentcount(rset.getInt("Ccount"));
			
				
				list.add(Phoogi);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}



	public ArrayList<Product_Hoogi> hoogiSearchContent(Connection conn, String word, int currentPage, int limit) {
		ArrayList<Product_Hoogi> list = new ArrayList<Product_Hoogi>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String query = 
				
		"SELECT * FROM (SELECT ROWNUM RNUM, BOARD_NUM, userid, btitle, bcontent, board_date, product_num, " + 
		"boardOriginalFileName, boardRenameFileName, hoogireadcount," + 
		"(select count(*)  from hcomment a where a.board_num=c.board_num ) Ccount, commentcount from" + 
		"(SELECT * FROM product_hoogi where bcontent like ? " +
		"ORDER BY board_num desC) c)" + 
		"WHERE RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + word + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product_Hoogi Phoogi = new Product_Hoogi();
				
				Phoogi.setBoardnum(rset.getInt("board_num"));
				Phoogi.setUserid(rset.getString("userid"));
				Phoogi.setBtitle(rset.getString("btitle"));
				Phoogi.setBcontent(rset.getString("bcontent"));
				Phoogi.setBoarddate(rset.getDate("board_date"));
				Phoogi.setProductnum(rset.getString("product_num"));
				Phoogi.setBoardOriginalFileName(rset.getString("boardOriginalFileName"));
				Phoogi.setBoardRenameFileName(rset.getString("boardRenameFileName"));
				Phoogi.setCommentcount(rset.getInt("Ccount"));
			
				
				list.add(Phoogi);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}



	public ArrayList<Product_Hoogi> hoogiSearchTCmix(Connection conn, String word, int currentPage, int limit) {
		ArrayList<Product_Hoogi> list = new ArrayList<Product_Hoogi>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String query = 
				
		"SELECT * FROM (SELECT ROWNUM RNUM, BOARD_NUM, userid, btitle, bcontent, board_date, product_num, " + 
		"boardOriginalFileName, boardRenameFileName, hoogireadcount," + 
		"(select count(*)  from hcomment a where a.board_num=c.board_num ) Ccount, commentcount from" + 
		"(SELECT * FROM product_hoogi where bcontent like ? or btitle like ?" +
		"ORDER BY board_num desC) c)" + 
		"WHERE RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + word + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product_Hoogi Phoogi = new Product_Hoogi();
				
				Phoogi.setBoardnum(rset.getInt("board_num"));
				Phoogi.setUserid(rset.getString("userid"));
				Phoogi.setBtitle(rset.getString("btitle"));
				Phoogi.setBcontent(rset.getString("bcontent"));
				Phoogi.setBoarddate(rset.getDate("board_date"));
				Phoogi.setProductnum(rset.getString("product_num"));
				Phoogi.setBoardOriginalFileName(rset.getString("boardOriginalFileName"));
				Phoogi.setBoardRenameFileName(rset.getString("boardRenameFileName"));
				Phoogi.setCommentcount(rset.getInt("Ccount"));
			
				
				list.add(Phoogi);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}



	public ArrayList<Product_Hoogi> hoogiSearchWriter(Connection conn, String word, int currentPage, int limit) {
		ArrayList<Product_Hoogi> list = new ArrayList<Product_Hoogi>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String query = 
				
		"SELECT * FROM (SELECT ROWNUM RNUM, BOARD_NUM, userid, btitle, bcontent, board_date, product_num, " + 
		"boardOriginalFileName, boardRenameFileName, hoogireadcount," + 
		"(select count(*)  from hcomment a where a.board_num=c.board_num ) Ccount, commentcount from" + 
		"(SELECT * FROM product_hoogi where userid like ? " +
		"ORDER BY board_num desC) c)" + 
		"WHERE RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + word + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product_Hoogi Phoogi = new Product_Hoogi();
				
				Phoogi.setBoardnum(rset.getInt("board_num"));
				Phoogi.setUserid(rset.getString("userid"));
				Phoogi.setBtitle(rset.getString("btitle"));
				Phoogi.setBcontent(rset.getString("bcontent"));
				Phoogi.setBoarddate(rset.getDate("board_date"));
				Phoogi.setProductnum(rset.getString("product_num"));
				Phoogi.setBoardOriginalFileName(rset.getString("boardOriginalFileName"));
				Phoogi.setBoardRenameFileName(rset.getString("boardRenameFileName"));
				Phoogi.setCommentcount(rset.getInt("Ccount"));
			
				
				list.add(Phoogi);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}



	public int deleteComment(Connection conn, int hoogiNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from hcomment "
				+ "where comment_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);				
			pstmt.setInt(1, hoogiNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	




	

	
	
	
}//전체
