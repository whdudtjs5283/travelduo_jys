package matchreview.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static common.JDBCTemplate.close;
import matchreview.model.vo.MatchReview;

public class MatchReviewDao {
	public MatchReviewDao() {}

	public int insertMember(Connection conn, MatchReview mreview) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into match_review values(?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mreview.getUserName());
			pstmt.setString(2, mreview.getEmail());
			pstmt.setString(3, mreview.getPhone());
			pstmt.setString(4, mreview.getReview());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	



}
