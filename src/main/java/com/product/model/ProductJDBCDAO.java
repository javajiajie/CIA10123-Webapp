package com.product.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductJDBCDAO implements ProductDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "CIA101_23";

	private static final String INSERT_STMT = 
			"INSERT INTO general_product (seller_id, category_id, name, description, price, quantity, review_status, product_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
			"SELECT seller_id, category_id, name, description, price, quantity, review_status, product_status FROM general_product order by product_id";
	private static final String GET_ONE_STMT = 
			"SELECT seller_id, category_id, name, description, price, quantity, review_status, product_status FROM general_product where product_id = ?";
	private static final String UPDATE = 
			"UPDATE general_product set seller_id=?, category_id=?, name=?, description=?, price=?, quantity=? review_status=? product_status=? where empno = ?";

	@Override
	public void insert(ProductVO productVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, productVO.getProduct_id());
			pstmt.setInt(2, productVO.getCategory_id());
			pstmt.setString(3, productVO.getName());
			pstmt.setString(4, productVO.getDescription());
			pstmt.setInt(5, productVO.getPrice());
			pstmt.setInt(6, productVO.getQuantity());
			pstmt.setByte(7, productVO.getReview_status());
			pstmt.setByte(8, productVO.getProduct_status());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}


	@Override
	public void update(ProductVO productVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, productVO.getProduct_id());
			pstmt.setInt(2, productVO.getCategory_id());
			pstmt.setString(3, productVO.getName());
			pstmt.setString(4, productVO.getDescription());
			pstmt.setInt(5, productVO.getPrice());
			pstmt.setInt(6, productVO.getQuantity());
			pstmt.setByte(7, productVO.getReview_status());
			pstmt.setByte(8, productVO.getProduct_status());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void remove(Integer product_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProductVO indByPrimaryKey(Integer product_id) {
		// TODO Auto-generated method stub
		
		ProductVO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, product_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				productVO = new ProductVO();
				productVO.setProduct_id(rs.getInt("product_id"));
				productVO.setSeller_id(rs.getInt("seller_id"));
				productVO.setCategory_id(rs.getInt("category_id"));
				productVO.setName(rs.getString("name"));
				productVO.setDescription(rs.getString("description"));
				productVO.setPrice(rs.getInt("price"));
				productVO.setQuantity(rs.getInt("quantity"));
				productVO.setReview_status(rs.getByte("review_status"));
				productVO.setProduct_status(rs.getByte("product_status"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return productVO;
	}

	@Override
	public List<ProductVO> getAll() {
		// TODO Auto-generated method stub
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				productVO = new ProductVO();
				productVO.setProduct_id(rs.getInt("product_id"));
				productVO.setSeller_id(rs.getInt("seller_id"));
				productVO.setCategory_id(rs.getInt("category_id"));
				productVO.setName(rs.getString("name"));
				productVO.setDescription(rs.getString("description"));
				productVO.setPrice(rs.getInt("price"));
				productVO.setQuantity(rs.getInt("quantity"));
				productVO.setReview_status(rs.getByte("review_status"));
				productVO.setProduct_status(rs.getByte("product_status"));
				list.add(productVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

}
