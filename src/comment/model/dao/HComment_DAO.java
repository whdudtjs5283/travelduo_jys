package comment.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import board_hoogi.model.vo.Product_Hoogi;
import comment.model.vo.HComment;

public class HComment_DAO {
	
	public HComment_DAO() {}

		// 게시글 번호와 일치하는 해당 댓글을 출력하는 쿼리문
	public ArrayList<HComment> select_HComment(Connection conn, int hoogiNo) {
		
		ArrayList<HComment> clist = new ArrayList<HComment>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//게시글 번호(board_num)로 ? 를 지정함
		/*String query = "select comment_num, ?,"
				+ " userid, userpwd, hcomment_content"
				+ " from hcomment";*/
		
		String query = "select *from hcomment where board_num=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, hoogiNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				HComment hcomment = new HComment();
				hcomment.setCOMMENT_NUM(rset.getInt("comment_num"));
				hcomment.setBOARD_NUM(rset.getInt("board_num"));
				hcomment.setUserid(rset.getString("userid"));
				hcomment.setHCOMMENT_CONTENT(rset.getString("hcomment_content"));
				
				clist.add(hcomment);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return clist;
	}

	public int insertComment(Connection conn, HComment hcomment, int originalNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = 
		
		"insert into Hcomment values (hcomment_seq.nextval, ?, ?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, hcomment.getBOARD_NUM());
			pstmt.setString(2, hcomment.getUserid());
			pstmt.setString(3, hcomment.getHCOMMENT_CONTENT());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/*public int insertComment(Connection conn, HComment hcomment) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into Hcomment values (hcomment_seq.nextval , 129, 'test', 'test', '129번글관련'  );";
		return 0;
	}*/
	
	
	
	

	

}//전체
