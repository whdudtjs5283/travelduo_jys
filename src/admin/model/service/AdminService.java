package admin.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import admin.model.dao.AdminDao;
import member.model.vo.Member;
import product.model.vo.Product;

public class AdminService {
	
	private AdminDao adao = new AdminDao();
	
	public AdminService() {}

	public ArrayList<Member> memberManagement() {
		Connection conn = getConnection();
		ArrayList<Member> list = adao.memberManagement(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Product> searchProductNum(String productNum) {
		Connection conn = getConnection();
		ArrayList<Product> list = adao.searchProductNum(conn, productNum);
		close(conn);
		return list;
	}

	public ArrayList<Product> searchCountry(String country) {
		Connection conn = getConnection();
		ArrayList<Product> list = adao.searchCountry(conn, country);
		close(conn);
		return list;
	}

	public ArrayList<Product> searchDestination(String destination) {
		Connection conn = getConnection();
		ArrayList<Product> list = adao.searchDestination(conn, destination);
		close(conn);
		return list;
	}

	public ArrayList<Member> searchMMId(String userId) {
		Connection conn = getConnection();
		ArrayList<Member> list = adao.searchMMId(conn, userId);
		close(conn);
		return list;
	}

	public ArrayList<Member> searchMMName(String userName) {
		Connection conn = getConnection();
		ArrayList<Member> list = adao.searchMMName(conn, userName);
		close(conn);
		return list;
	}

	public ArrayList<Member> searchMMAge(int age) {
		Connection conn = getConnection();
		ArrayList<Member> list = adao.searchMMAge(conn, age);
		close(conn);
		return list;
	}

	public ArrayList<Member> searchMMGender(String gender) {
		Connection conn = getConnection();
		ArrayList<Member> list = adao.searchMMGender(conn, gender);
		close(conn);
		return list;
	}

	public ArrayList<Member> searchMMPhone(String phone) {
		Connection conn = getConnection();
		ArrayList<Member> list = adao.searchMMPhone(conn, phone);
		close(conn);
		return list;
	}

	public ArrayList<Member> searchMMEmail(String email) {
		Connection conn = getConnection();
		ArrayList<Member> list = adao.searchMMEmail(conn, email);
		close(conn);
		return list;
	}

}
