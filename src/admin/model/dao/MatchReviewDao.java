package admin.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import admin.model.vo.MatchReview;

public class MatchReviewDao {

	public ArrayList<MatchReview> reviewManagement(Connection conn) {
		ArrayList<MatchReview> list = new ArrayList<MatchReview>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT rownum rnum, USERNAME, EMAIL, PHONE, REVIEW from MATCH_REVIEW order by rnum desc";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				MatchReview mreview = new MatchReview();
				
				mreview.setUserName(rset.getString("username"));
				mreview.setEmail(rset.getString("email"));
				mreview.setPhone(rset.getString("phone"));
				mreview.setReview(rset.getString("review"));
					
				
				list.add(mreview);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

}
