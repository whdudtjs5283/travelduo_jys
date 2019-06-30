package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCTemplate {
//싱글톤 패턴 static
	

	public static Connection getConnection() {
	/*	Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"travelduo",
					"travelduo");	
		} catch (Exception e) {
				e.printStackTrace();	
		}
		return conn;
	 */
		Connection conn = null;
		try {

			Context initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:comp/env/jdbc/oraDB"); //자바 컴퓨터 env(환경에서) oraDB라는 이름을 찾아라.
			conn=ds.getConnection();
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
		
		
	public static void close(Connection conn) {
		
		try {
			if( conn !=null && !conn.isClosed()) {
				conn.close();	}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	} 
	
	public static void close(Statement stmt) {
		
		try {
			if(stmt!=null && !stmt.isClosed()) {
				stmt.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		
		try {
			if(rset !=null && !rset.isClosed()) {
				rset.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		
		try {
			if(conn !=null && !conn.isClosed())
				conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		
		try {
			if(conn !=null && !conn.isClosed()) {
				conn.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
