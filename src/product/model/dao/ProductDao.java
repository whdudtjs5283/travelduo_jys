package product.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import product.model.vo.Product;

public class ProductDao {

	public ArrayList<Product>productAllList(Connection conn) {
		ArrayList<Product> list = new ArrayList<Product>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select product_num, product_name, product_list_no, country, destination, r_banner_image_1, r_banner_image_2, r_banner_image_3"
				+ " from product order by product_list_no desc";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Product product = new Product();
				
				product.setProductNum(rset.getString("product_num"));
				product.setProductName(rset.getString("product_name"));
				product.setProductListNo(rset.getInt("product_list_no"));
				product.setCountry(rset.getString("country"));
				product.setDestination(rset.getString("destination"));
				product.setrBannerImage1(rset.getString("r_banner_image_1"));
				product.setrBannerImage2(rset.getString("r_banner_image_2"));
				product.setrBannerImage3(rset.getString("r_banner_image_3"));

				
				list.add(product);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
	
	public ArrayList<Product>productOutAllList(Connection conn) {
		ArrayList<Product> list = new ArrayList<Product>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select product_num, product_name, product_list_no, country, destination, r_banner_image_1, r_banner_image_2, r_banner_image_3"
				+ " from product where country != '한국' order by product_list_no desc";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Product product = new Product();
				
				product.setProductNum(rset.getString("product_num"));
				product.setProductName(rset.getString("product_name"));
				product.setProductListNo(rset.getInt("product_list_no"));
				product.setCountry(rset.getString("country"));
				product.setDestination(rset.getString("destination"));
				product.setrBannerImage1(rset.getString("r_banner_image_1"));
				product.setrBannerImage2(rset.getString("r_banner_image_2"));
				product.setrBannerImage3(rset.getString("r_banner_image_3"));
				
				
				
				list.add(product);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
	
	public ArrayList<Product>productInAllList(Connection conn) {
		ArrayList<Product> list = new ArrayList<Product>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select product_num, product_name, product_list_no, country, destination, r_banner_image_1, r_banner_image_2, r_banner_image_3"
				+ " from product where country = '한국' order by product_list_no desc";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Product product = new Product();
				
				product.setProductNum(rset.getString("product_num"));
				product.setProductName(rset.getString("product_name"));
				product.setProductListNo(rset.getInt("product_list_no"));
				product.setCountry(rset.getString("country"));
				product.setDestination(rset.getString("destination"));
				product.setrBannerImage1(rset.getString("r_banner_image_1"));
				product.setrBannerImage2(rset.getString("r_banner_image_2"));
				product.setrBannerImage3(rset.getString("r_banner_image_3"));
				
				
				
				list.add(product);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
	
	public ArrayList<Product> countryList(Connection conn, String country) {
		ArrayList<Product> list = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select product_num, product_name, product_list_no, country, destination, r_banner_image_1, r_banner_image_2, r_banner_image_3"
				+ " from product where country = ? order by product_list_no desc";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, country);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product product = new Product();
				
				product.setProductNum(rset.getString("product_num"));
				product.setProductName(rset.getString("product_name"));
				product.setProductListNo(rset.getInt("product_list_no"));
				product.setCountry(country);
				product.setDestination(rset.getString("destination"));
				product.setrBannerImage1(rset.getString("r_banner_image_1"));
				product.setrBannerImage2(rset.getString("r_banner_image_2"));
				product.setrBannerImage3(rset.getString("r_banner_image_3"));

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

	public ArrayList<Product> destinationList(Connection conn, String destination) {
		ArrayList<Product> list = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select product_num, product_name, product_list_no, country, destination from product where destination = ? order by product_list_no desc";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, destination);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product product = new Product();
				
				product.setProductNum(rset.getString("product_num"));
				product.setProductName(rset.getString("product_name"));
				product.setProductListNo(rset.getInt("product_list_no"));
				product.setCountry(rset.getString("country"));
				product.setDestination(destination);
				
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
	
	
	public Product detailView(Connection conn, String productNum) {
		Product product = new Product();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from product where product_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productNum);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				product = new Product();
				
				product.setProductNum(productNum);
				product.setProductName(rset.getString("product_name"));
				product.setProductListNo(rset.getInt("product_list_no"));
				product.setrProduct(rset.getString("r_product"));
				product.setCountry(rset.getString("country"));
				product.setDestination(rset.getString("destination"));
				product.setDestinationInfo(rset.getString("destination_info"));
				product.setTouristSpot1(rset.getString("tourist_spot_1"));
				product.setTouristSpot1Info(rset.getString("tourist_spot_1_info"));
				product.setTouristSpot2(rset.getString("tourist_spot_2"));
				product.setTouristSpot2Info(rset.getString("tourist_spot_2_info"));
				product.setTouristSpot3(rset.getString("tourist_spot_3"));
				product.setTouristSpot3Info(rset.getString("tourist_spot_3_info"));
				product.setrBannerImage1(rset.getString("r_banner_image_1"));
				product.setrBannerImage2(rset.getString("r_banner_image_2"));
				product.setrBannerImage3(rset.getString("r_banner_image_3"));
				product.setrDestinationImage(rset.getString("r_destination_image"));
				product.setrTouristImage1(rset.getString("r_tourist_image_1"));
				product.setrTouristImage2(rset.getString("r_tourist_image_2"));
				product.setrTouristImage3(rset.getString("r_tourist_image_3"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return product;
	}

	public int writeProduct(Connection conn, Product product) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "insert into product values(?, ?, (select max(product_list_no) + 1 from product), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, product.getProductNum());
			pstmt.setString(2, product.getProductName());
			pstmt.setString(3, product.getrProduct());
			pstmt.setString(4, product.getCountry());
			pstmt.setString(5, product.getDestination());
			pstmt.setString(6, product.getDestinationInfo());
			pstmt.setString(7, product.getTouristSpot1());
			pstmt.setString(8, product.getTouristSpot1Info());
			pstmt.setString(9, product.getTouristSpot2());
			pstmt.setString(10, product.getTouristSpot2Info());
			pstmt.setString(11, product.getTouristSpot3());
			pstmt.setString(12, product.getTouristSpot3Info());
			pstmt.setString(13, product.getoBannerImage1());
			pstmt.setString(14, product.getrBannerImage1());
			pstmt.setString(15, product.getoBannerImage2());
			pstmt.setString(16, product.getrBannerImage2());
			pstmt.setString(17, product.getoBannerImage3());
			pstmt.setString(18, product.getrBannerImage3());
			pstmt.setString(19, product.getoDestinationImage());
			pstmt.setString(20, product.getrDestinationImage());
			pstmt.setString(21, product.getoTouristImage1());
			pstmt.setString(22, product.getrTouristImage1());
			pstmt.setString(23, product.getoTouristImage2());
			pstmt.setString(24, product.getrTouristImage2());
			pstmt.setString(25, product.getoTouristImage3());
			pstmt.setString(26, product.getrTouristImage3());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteProduct(Connection conn, String productNum) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "delete from product where product_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productNum);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Product updateViewProduct(Connection conn, String productNum) {
		Product product = new Product();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from product where product_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productNum);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				product = new Product();
				
				product.setProductNum(productNum);
				product.setProductName(rset.getString("product_name"));
				product.setrProduct(rset.getString("r_product"));
				product.setCountry(rset.getString("country"));
				product.setDestination(rset.getString("destination"));
				product.setDestinationInfo(rset.getString("destination_info"));
				product.setTouristSpot1(rset.getString("tourist_spot_1"));
				product.setTouristSpot1Info(rset.getString("tourist_spot_1_info"));
				product.setTouristSpot2(rset.getString("tourist_spot_2"));
				product.setTouristSpot2Info(rset.getString("tourist_spot_2_info"));
				product.setTouristSpot3(rset.getString("tourist_spot_3"));
				product.setTouristSpot3Info(rset.getString("tourist_spot_3_info"));
				product.setoBannerImage1(rset.getString("o_banner_image_1"));
				product.setrBannerImage1(rset.getString("r_banner_image_1"));
				product.setoBannerImage2(rset.getString("o_banner_image_2"));
				product.setrBannerImage2(rset.getString("r_banner_image_2"));
				product.setoBannerImage3(rset.getString("o_banner_image_3"));
				product.setrBannerImage3(rset.getString("r_banner_image_3"));
				product.setoDestinationImage(rset.getString("o_destination_image"));
				product.setrDestinationImage(rset.getString("r_destination_image"));
				product.setoTouristImage1(rset.getString("o_tourist_image_1"));
				product.setrTouristImage1(rset.getString("r_tourist_image_1"));
				product.setoTouristImage2(rset.getString("o_tourist_image_2"));
				product.setrTouristImage2(rset.getString("r_tourist_image_2"));
				product.setoTouristImage3(rset.getString("o_tourist_image_3"));
				product.setrTouristImage3(rset.getString("r_tourist_image_3"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return product;
	}

	public int updateProduct(Connection conn, Product product) {
int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "update product set product_num = ?, product_name = ?, r_product = ?, country = ?, destination = ?, destination_info = ?,"
						+ " tourist_spot_1 = ?, tourist_spot_1_info = ?, tourist_spot_2 = ?, tourist_spot_2_info = ?, tourist_spot_3 = ?, tourist_spot_3_info = ?,"
						+ " o_banner_image_1 = ?, r_banner_image_1 = ?, o_banner_image_2 = ?, r_banner_image_2 = ?, o_banner_image_3 = ?, r_banner_image_3 = ?,"
						+ " o_destination_image = ?, r_destination_image = ?, o_tourist_image_1 = ?, r_tourist_image_1 = ?, o_tourist_image_2 = ?, r_tourist_image_2 = ?,"
						+ " o_tourist_image_3 = ?, r_tourist_image_3 = ? where product_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, product.getProductNum());
			pstmt.setString(2, product.getProductName());
			pstmt.setString(3, product.getrProduct());
			pstmt.setString(4, product.getCountry());
			pstmt.setString(5, product.getDestination());
			pstmt.setString(6, product.getDestinationInfo());
			pstmt.setString(7, product.getTouristSpot1());
			pstmt.setString(8, product.getTouristSpot1Info());
			pstmt.setString(9, product.getTouristSpot2());
			pstmt.setString(10, product.getTouristSpot2Info());
			pstmt.setString(11, product.getTouristSpot3());
			pstmt.setString(12, product.getTouristSpot3Info());
			pstmt.setString(13, product.getoBannerImage1());
			pstmt.setString(14, product.getrBannerImage1());
			pstmt.setString(15, product.getoBannerImage2());
			pstmt.setString(16, product.getrBannerImage2());
			pstmt.setString(17, product.getoBannerImage3());
			pstmt.setString(18, product.getrBannerImage3());
			pstmt.setString(19, product.getoDestinationImage());
			pstmt.setString(20, product.getrDestinationImage());
			pstmt.setString(21, product.getoTouristImage1());
			pstmt.setString(22, product.getrTouristImage1());
			pstmt.setString(23, product.getoTouristImage2());
			pstmt.setString(24, product.getrTouristImage2());
			pstmt.setString(25, product.getoTouristImage3());
			pstmt.setString(26, product.getrTouristImage3());
			pstmt.setString(27, product.getProductNum());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
































