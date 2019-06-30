package board_hoogi.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductReplyDAO {

	public int getAllCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from product_Hoogi";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	

}
