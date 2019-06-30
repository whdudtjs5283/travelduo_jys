package matchinfo.model.service;



import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import matchinfo.model.dao.MatchInfoDao;
import matchinfo.model.vo.MatchInfo;


public class MatchInfoService {
	
	private MatchInfoDao mdao = new MatchInfoDao();
	
	public MatchInfoService (){}

	public int insertMatchInfo(MatchInfo minfo) {
		Connection conn = getConnection();
		int result = mdao.insertMatchInfo(conn, minfo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
		
	}


	public MatchInfo selectLogin(String matchPrivate) {
		Connection conn = getConnection();
		MatchInfo matchState = mdao.selectLogin(conn, matchPrivate); //dao로 넘김
		System.out.println("matchState" + matchState);
		close(conn);
		
		return matchState;
		
	}

	public int updateMatchInfo(MatchInfo minfo) {
		Connection conn = getConnection();
		int result = mdao.updateMatchInfo(conn, minfo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}


	public ArrayList<MatchInfo> selectList(String user) {
		Connection conn = getConnection();
		ArrayList<MatchInfo> list = mdao.selectList(conn, user);
		close(conn);
		return list;
	}

	public int deleteMatchInfo(int matchInfoNo) {
		Connection conn = getConnection();
		int result = mdao.deleteMatchInfo(conn, matchInfoNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public ArrayList<MatchInfo> matchSearchArea(String matchArea, int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<MatchInfo> list = mdao.selectSearchAreaList(conn, matchArea, currentPage, limit);
		close(conn);
		return list;
	}
	

	public ArrayList<MatchInfo> profileMatch(String matchArea, String matchYear) {
		Connection conn = getConnection();
		ArrayList<MatchInfo> list = mdao.profileMatch(conn, matchArea, matchYear);
		close(conn);
		return list;
	}

	public MatchInfo selectOne(int matchNum) {
		Connection conn = getConnection();
		MatchInfo matchInfo = mdao.selectOne(conn, matchNum);
		close(conn);
		return matchInfo;
	}
	
	public MatchInfo selectMatchinfo(String fromUserID) {
		Connection conn = getConnection();
		MatchInfo matchInfo = mdao.selectMatchinfo(conn, fromUserID);
		close(conn);
		return matchInfo;
	}


}
