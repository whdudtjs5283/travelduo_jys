package notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

import static common.JDBCTemplate.*;

public class NoticeService {
	private NoticeDao ndao = new NoticeDao();
	
	public NoticeService() {}
	
	public ArrayList<Notice> selectList(int currentPage, int limit){
		Connection conn = getConnection();
		ArrayList<Notice> list = ndao.selectList(conn, currentPage, limit);
		close(conn);
		return list;
	}
	
	public Notice selectOne(int noticeNo) {
		Connection conn = getConnection();
		Notice notice = ndao.selectOne(conn, noticeNo);
		close(conn);
		return notice;
	}
	
	public int insertNotice(Notice notice) {
		Connection conn = getConnection();
		int result = ndao.insertNotice(conn, notice);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateNotice(Notice notice) {
		Connection conn = getConnection();
		int result = ndao.updateNotice(conn, notice);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	public int deleteNotice(int noticeNo) {
		Connection conn = getConnection();
		int result = ndao.deleteNotice(conn, noticeNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public ArrayList<Notice> selectSearchTitle(String noticeTitle) {
		Connection conn = getConnection();
		ArrayList<Notice> List = ndao.selectSearchTitle(conn, noticeTitle);
		close(conn);
		return List;
	}

	public ArrayList<Notice> selectTop5Write() {
		Connection conn = getConnection();
		ArrayList<Notice> list = ndao.selectTop5Write(conn);
		close(conn);
		return list;
		
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = ndao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Notice> NoticeSearchTitle(String title, int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<Notice> list = ndao.selectTitleList(conn, title, currentPage, limit);
		close(conn);
		return list;
	}

	public int getTitleListCount(String title) {
		Connection conn = getConnection();
		int listCount = ndao.getTitleListCount(conn, title);
		close(conn);
		return listCount;
	}
}











