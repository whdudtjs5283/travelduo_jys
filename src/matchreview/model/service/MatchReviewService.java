package matchreview.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import matchreview.model.dao.MatchReviewDao;
import matchreview.model.vo.MatchReview;

public class MatchReviewService {
	private MatchReviewDao mdao = new MatchReviewDao();

	public int insertReview(MatchReview mreview) {
		Connection conn = getConnection();
		int result = mdao.insertMember(conn, mreview);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

}
