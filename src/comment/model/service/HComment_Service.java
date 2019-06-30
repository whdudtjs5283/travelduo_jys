package comment.model.service;

import java.util.ArrayList;
import board_hoogi.model.dao.Product_Hoogi_DAO;
import java.sql.Connection;
import static common.JDBCTemplate.*;
import comment.model.vo.HComment;
import comment.model.dao.HComment_DAO;


public class HComment_Service {
	
	private HComment_DAO Cdao = new HComment_DAO();
	
	public HComment_Service () {}

	public ArrayList<HComment> select_HComment(int hoogiNo) {
		Connection conn = getConnection();
		ArrayList<HComment> clist = Cdao.select_HComment(conn, hoogiNo);
		close(conn);
		return clist;
	}
	
	

	public int insertComment(HComment hcomment, int originalNo) {
		Connection conn = getConnection();
		int result = Cdao.insertComment(conn, hcomment, originalNo);
		if(result >0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	/*public int insertComment(HComment hcomment) {
		Connection conn = getConnection();
		int result = Cdao.insertComment(conn, hcomment);
		if(result >0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
		
	}*/

	

	
	
	
}//전체
