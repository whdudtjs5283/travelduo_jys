package admin.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import member.model.vo.Member;
import product.model.vo.Product;

public class AdminDao {

	public ArrayList<Member> memberManagement(Connection conn) {
		ArrayList<Member> list = new ArrayList<Member>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select rownum rnum, userid, username, age, gender, phone, email from member order by rnum desc";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Member member = new Member();
				
				member.setUserId(rset.getString("userid"));
				member.setUserName(rset.getString("username"));
				member.setAge(rset.getInt("age"));
				member.setGender(rset.getString("gender"));
				member.setPhone(rset.getString("phone"));
				member.setEmail(rset.getString("email"));
				
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}


	public ArrayList<Product> searchProductNum(Connection conn, String productNum) {
		ArrayList<Product> list = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from product where product_num like ?"
				+ " order by product_list_no desc";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + productNum + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product product = new Product();
				
				product.setProductNum(rset.getString("product_num"));
				product.setProductName(rset.getString("product_name"));
				product.setProductListNo(rset.getInt("product_list_no"));
				product.setCountry(rset.getString("country"));
				product.setDestination(rset.getString("destination"));
				
				list.add(product);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Product> searchCountry(Connection conn, String country) {
		ArrayList<Product> list = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from product where country like ?"
				+ " order by product_list_no desc";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + country + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product product = new Product();
				
				product.setProductNum(rset.getString("product_num"));
				product.setProductName(rset.getString("product_name"));
				product.setProductListNo(rset.getInt("product_list_no"));
				product.setCountry(rset.getString("country"));
				product.setDestination(rset.getString("destination"));
				
				list.add(product);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Product> searchDestination(Connection conn, String destination) {
		ArrayList<Product> list = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from product where destination like ?"
				+ " order by product_list_no desc";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + destination + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product product = new Product();
				
				product.setProductNum(rset.getString("product_num"));
				product.setProductName(rset.getString("product_name"));
				product.setProductListNo(rset.getInt("product_list_no"));
				product.setCountry(rset.getString("country"));
				product.setDestination(rset.getString("destination"));
				
				list.add(product);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public ArrayList<Member> searchMMId(Connection conn, String userId) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where userid like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + userId + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = new Member();
				
				member.setUserId(rset.getString("userid"));
				member.setUserName(rset.getString("username"));
				member.setAge(rset.getInt("age"));
				member.setGender(rset.getString("gender"));
				member.setPhone(rset.getString("phone"));
				member.setEmail(rset.getString("email"));
			
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public ArrayList<Member> searchMMName(Connection conn, String userName) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where username like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + userName + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = new Member();
				
				member.setUserId(rset.getString("userid"));
				member.setUserName(rset.getString("username"));
				member.setAge(rset.getInt("age"));
				member.setGender(rset.getString("gender"));
				member.setPhone(rset.getString("phone"));
				member.setEmail(rset.getString("email"));
			
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public ArrayList<Member> searchMMAge(Connection conn, int age) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where age like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + age + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = new Member();
				
				member.setUserId(rset.getString("userid"));
				member.setUserName(rset.getString("username"));
				member.setAge(rset.getInt("age"));
				member.setGender(rset.getString("gender"));
				member.setPhone(rset.getString("phone"));
				member.setEmail(rset.getString("email"));
			
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public ArrayList<Member> searchMMGender(Connection conn, String gender) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where gender like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + gender + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = new Member();
				
				member.setUserId(rset.getString("userid"));
				member.setUserName(rset.getString("username"));
				member.setAge(rset.getInt("age"));
				member.setGender(rset.getString("gender"));
				member.setPhone(rset.getString("phone"));
				member.setEmail(rset.getString("email"));
			
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public ArrayList<Member> searchMMPhone(Connection conn, String phone) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where phone like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + phone + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = new Member();
				
				member.setUserId(rset.getString("userid"));
				member.setUserName(rset.getString("username"));
				member.setAge(rset.getInt("age"));
				member.setGender(rset.getString("gender"));
				member.setPhone(rset.getString("phone"));
				member.setEmail(rset.getString("email"));
			
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public ArrayList<Member> searchMMEmail(Connection conn, String email) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where email like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + email + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = new Member();
				
				member.setUserId(rset.getString("userid"));
				member.setUserName(rset.getString("username"));
				member.setAge(rset.getInt("age"));
				member.setGender(rset.getString("gender"));
				member.setPhone(rset.getString("phone"));
				member.setEmail(rset.getString("email"));
			
				list.add(member);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}

