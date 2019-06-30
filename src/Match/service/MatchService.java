package Match.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Match.dao.MatchMessageDAO;
import Match.vo.MatchMessage;
import board_hoogi.model.vo.Product_Hoogi;

import static common.JDBCTemplate.*;

public class MatchService {
	
	private MatchMessageDAO MessageDAO = new MatchMessageDAO();
	
	public MatchService() {}

	public int insertMatch(MatchMessage matchMessage) {
		Connection conn = getConnection();
		int result = MessageDAO.inserthoogi(conn, matchMessage);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int getListMessage(String userID) {
		Connection conn = getConnection();
		int listcount = MessageDAO.getListCount(conn, userID);
		close(conn);
		return listcount;
	}


	public ArrayList<MatchMessage> select_MatchMessage(String userID, int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<MatchMessage> list = MessageDAO.select_MatchMessage(conn, userID, currentPage, limit);
		close(conn);
		return list;
	}

	
	//쪽지 한개 선택
	
	public MatchMessage selectMessage(int messageNo) {
		Connection conn = getConnection();
		MatchMessage Message = MessageDAO.selectHoogiNo(conn, messageNo);
		close(conn);
		return Message;
	}

	
	//조회수 올림
	public void addReadCount(int messageNo) {
		Connection conn = getConnection();
		int result = MessageDAO.addReadCount(conn, messageNo);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
	}




}
