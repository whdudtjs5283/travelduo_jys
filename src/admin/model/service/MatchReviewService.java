package admin.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import admin.model.dao.MatchReviewDao;
import admin.model.vo.MatchReview;

public class MatchReviewService {
	
	private MatchReviewDao mdao = new MatchReviewDao();
	
	public MatchReviewService() {}

	public ArrayList<MatchReview> reviewManagement() {
		Connection conn = getConnection();
		ArrayList<MatchReview> list = mdao.reviewManagement(conn);
		close(conn);
		return list;
	}

}
