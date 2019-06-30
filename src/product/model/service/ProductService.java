package product.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import product.model.dao.ProductDao;
import product.model.vo.Product;

public class ProductService {
private ProductDao pdao = new ProductDao();
	
	public ProductService() {}

	public ArrayList<Product> productAllList() {
		Connection conn = getConnection();
		ArrayList<Product> list = pdao.productAllList(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Product> productOutAllList() {
		Connection conn = getConnection();
		ArrayList<Product> list = pdao.productOutAllList(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Product> productInAllList() {
		Connection conn = getConnection();
		ArrayList<Product> list = pdao.productInAllList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Product> countryList(String country) {
		Connection conn = getConnection();
		ArrayList<Product> list = pdao.countryList(conn, country);
		close(conn);
		return list;
	}
	
	public ArrayList<Product> destinationList(String destination) {
		Connection conn = getConnection();
		ArrayList<Product> list = pdao.destinationList(conn, destination);
		close(conn);
		return list;
	}
	

	public Product detailView(String productNum) {
		Connection conn = getConnection();
		Product product = pdao.detailView(conn, productNum);
		close(conn);
		return product;
	}

	public int writeProduct(Product product) {
		Connection conn = getConnection();
		int result = pdao.writeProduct(conn, product);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int deleteProduct(String productNum) {
		Connection conn = getConnection();
		int result = pdao.deleteProduct(conn, productNum);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public Product updateViewProduct(String productNum) {
		Connection conn = getConnection();
		Product product = pdao.updateViewProduct(conn, productNum);
		close(conn);
		return product;
	}

	public int updateProduct(Product product) {
		Connection conn = getConnection();
		int result = pdao.updateProduct(conn, product);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}


}
