package board_hoogi.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import static common.JDBCTemplate.*;

import board_hoogi.model.dao.ProductReplyDAO;
import board_hoogi.model.dao.Product_Hoogi_DAO;
import board_hoogi.model.vo.ProductReplyCount;
import board_hoogi.model.vo.Product_Hoogi;


public class Product_Hoogi_Service2 {
	
	private Product_Hoogi_DAO Pdao = new Product_Hoogi_DAO();
	private ProductReplyDAO PRdao = new ProductReplyDAO();
	
	public Product_Hoogi_Service2() {}

	//이건 전체를 가져오는 메소드임 select_Hoogi
	public ArrayList<Product_Hoogi> select_Hoogi(int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<Product_Hoogi> list = Pdao.select_Hoogi(conn, currentPage, limit);
		close(conn);
		return list;
	}
	
	//게시글 한개 번호로 추출
	public Product_Hoogi selectHoogiNo(int HoogiNo) {
		Connection conn = getConnection();
		Product_Hoogi Phoogi = Pdao.selectHoogiNo(conn, HoogiNo);
		close(conn);
		return Phoogi;
	}
	
	
	//이건 댓글갯수 포함안한 카운트
	public int getListCount() {
		Connection conn = getConnection();
		int listcount = Pdao.getListCount(conn);
		close(conn);
		return listcount;
	}
	
	//해당 원글 댓글카운트 포함
	public int getAllCount() {
		
		Connection conn = getConnection();
		int listcount = PRdao.getAllCount(conn);
		close(conn);
		return listcount;
	}


	public int inserthoogi(Product_Hoogi phoogi) {
		Connection conn = getConnection();
		int result = Pdao.inserthoogi(conn, phoogi);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateHoogi(Product_Hoogi phoogi) {
		Connection conn = getConnection();
		int result = Pdao.updateHoogi(conn, phoogi);
		if(result >0)
				commit(conn);
		else
				rollback(conn);
		close(conn);
		
		return result;
	}

	


	
	//시작행 끝행 계산
	public ArrayList<Product_Hoogi> selectList (
			Connection conn, int currentPage, int limit) {
				
		//-> 페이징 관련 메소드 시작행과 끝행 계산함
		return null;
		
	}


	public ArrayList<Product_Hoogi> hoogiSearchWriter(String hoogiWriter) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Product_Hoogi> hoogiSearchContent(String hoogiContent){
		return null;
	}


	public int insertReply(Product_Hoogi replyBoard) {
		int result = 0;
		return result;
	}

	public int updateReply(Product_Hoogi replyHoogi) {
		return 0;
	//--> 리플 수정하는 메소드
	}
	
	public void updateReplySeq(Product_Hoogi replyHoogi) {
		
	}

	public void addReadCount(int hoogiNo) {
		Connection conn = getConnection();
		int result = Pdao.addReadCount(conn, hoogiNo);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
	}

	public int deleteHoogi(int hoogiNo) {
		Connection conn = getConnection();
		int result = Pdao.deleteHoogi(conn, hoogiNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public ArrayList<Product_Hoogi> hoogiSearchTitle(String word, int currentPage, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	

}
