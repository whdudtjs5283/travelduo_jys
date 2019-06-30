package qna.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import qna.model.dao.QNADao;
import qna.model.vo.QNA;

public class QNAService {
private QNADao qdao = new QNADao();
	
	public QNAService() {}
	
	public ArrayList<QNA> selectList(int currentPage, int limit){
		Connection conn = getConnection();
		ArrayList<QNA> list = qdao.selectList(conn, currentPage, limit);
		close(conn);
		return list;
	}
	
	public QNA selectOne(int qnaNo) {
		Connection conn = getConnection();
		QNA qna = qdao.selectOne(conn, qnaNo);
		close(conn);
		return qna;
	}
	
	public int insertQNA(QNA qna) {
		Connection conn = getConnection();
		int result = qdao.insertQNA(conn, qna);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateQNA(QNA qna) {
		Connection conn = getConnection();
		int result = qdao.updateQNA(conn, qna);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	public int deleteQNA(int qnaNo) {
		Connection conn = getConnection();
		int result = qdao.deleteQNA(conn, qnaNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public ArrayList<QNA> selectSearchTitle(String qnaTitle) {
		Connection conn = getConnection();
		ArrayList<QNA> List = qdao.selectSearchTitle(conn, qnaTitle);
		close(conn);
		return List;
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = qdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<QNA> QNASearchTitle(String title, int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<QNA> list = qdao.selectTitleList(conn, title, currentPage, limit);
		close(conn);
		return list;
	}

	public QNA selectQNA(int qnaNum) {
		Connection conn = getConnection();
		QNA qna = qdao.selectQNA(conn, qnaNum);
		close(conn);
		return qna;
	}

	public int insertReply(QNA replyQNA) {
		Connection conn = getConnection();
		int result = qdao.insertReply(conn, replyQNA);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int getTitleListCount(String title) {
		Connection conn = getConnection();
		int listCount = qdao.getTitleListCount(conn, title);
		close(conn);
		return listCount;
	}

	public int deleteQNAReply(int qnaNo) {
		Connection conn = getConnection();
		int result = qdao.deleteQNAReply(conn, qnaNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
}



