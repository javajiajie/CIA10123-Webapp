package com.product.model;

import java.sql.*;
import java.util.*;

public class ProductJDBCDAO implements ProductDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/general_product_shop?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "CIA101_23";

	private static final String INSERT_STMT = "INSERT INTO general_product (seller_id, category_id, name, description, price, quantity, review_status, product_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT product_id, seller_id, category_id, name, description, price, quantity, review_status, product_status FROM general_product order by product_id";
	private static final String GET_ONE_STMT = "SELECT product_id, seller_id, category_id, name, description, price, quantity, review_status, product_status FROM general_product where product_id = ?";
	private static final String UPDATE = "UPDATE general_product set seller_id=?, category_id=?, name=?, description=?, price=?, quantity=?, review_status=?, product_status=? where product_id = ?";

	@Override
	public void insert(ProductVO productVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

//			pstmt.setInt(1, productVO.getProductId());
			pstmt.setInt(1, productVO.getSellerId());
			pstmt.setInt(2, productVO.getCategoryId());
			pstmt.setString(3, productVO.getName());
			pstmt.setString(4, productVO.getDescription());
			pstmt.setInt(5, productVO.getPrice());
			pstmt.setInt(6, productVO.getQuantity());
			pstmt.setInt(7, productVO.getReviewStatus());
			pstmt.setInt(8, productVO.getProductStatus());

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

			pstmt.setInt(1, productVO.getSellerId());
			pstmt.setInt(2, productVO.getCategoryId());
			pstmt.setString(3, productVO.getName());
			pstmt.setString(4, productVO.getDescription());
			pstmt.setInt(5, productVO.getPrice());
			pstmt.setInt(6, productVO.getQuantity());
			pstmt.setInt(7, productVO.getReviewStatus());
			pstmt.setInt(8, productVO.getProductStatus());
			pstmt.setInt(9, productVO.getProductId());

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
	public ProductVO findByPrimaryKey(Integer productId) {
		// TODO Auto-generated method stub

		ProductVO productVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, productId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				productVO = new ProductVO();
				productVO.setProductId(rs.getInt("product_id"));
				productVO.setSellerId(rs.getInt("seller_id"));
				productVO.setCategoryId(rs.getInt("category_id"));
				productVO.setName(rs.getString("name"));
				productVO.setDescription(rs.getString("description"));
				productVO.setPrice(rs.getInt("price"));
				productVO.setQuantity(rs.getInt("quantity"));
				productVO.setReviewStatus(rs.getInt("review_status"));
				productVO.setProductStatus(rs.getInt("product_status"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

				productVO = new ProductVO();
				productVO.setProductId(rs.getInt("product_id"));
				productVO.setSellerId(rs.getInt("seller_id"));
				productVO.setCategoryId(rs.getInt("category_id"));
				productVO.setName(rs.getString("name"));
				productVO.setDescription(rs.getString("description"));
				productVO.setPrice(rs.getInt("price"));
				productVO.setQuantity(rs.getInt("quantity"));
				productVO.setReviewStatus(rs.getInt("review_status"));
				productVO.setProductStatus(rs.getInt("product_status"));
				list.add(productVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

	public static void main(String[] args) {
		ProductDAO_interface dao = new ProductJDBCDAO();
		// 新增
//		ProductVO bidProductVO1 = new ProductVO();
//		bidProductVO1.setProductId(101);
//		bidProductVO1.setSellerId(3);
//		bidProductVO1.setCategoryId(5);
//		bidProductVO1.setName("Kobe 球員卡");
//		bidProductVO1.setDescription("Kobe Bryant 球員卡 2002年 狀態良好");
//		bidProductVO1.setPrice(3000);
//		bidProductVO1.setQuantity(99);
//		bidProductVO1.setReviewStatus(0);
//		bidProductVO1.setProductStatus(1);
//		dao.insert(bidProductVO1);

		// 修改
//		ProductVO bidProductVO2 = new ProductVO();
//		bidProductVO2.setProductId(101);
//		bidProductVO2.setSellerId(3);
//		bidProductVO2.setCategoryId(5);
//		bidProductVO2.setName("Lebron 球員卡");
//		bidProductVO2.setDescription("Lebron James 球員卡 2002年 狀態良好");
//		bidProductVO2.setPrice(3000);
//		bidProductVO2.setQuantity(99);
//		bidProductVO2.setReviewStatus(0);
//		bidProductVO2.setProductStatus(1);
//		dao.update(bidProductVO2);


		// 查詢單筆
		ProductVO bidProductVO3 = dao.findByPrimaryKey(1);
		System.out.print(bidProductVO3.getProductId() + ",");
		System.out.print(bidProductVO3.getSellerId() + ",");
		System.out.print(bidProductVO3.getName() + ",");
		System.out.print(bidProductVO3.getCategoryId() + ",");
		System.out.print(bidProductVO3.getDescription() + ",");
		System.out.println();
		System.out.println("---------------------");

		// 查詢多筆
		List<ProductVO> list = dao.getAll();
		for (ProductVO aEmp : list) {
			System.out.print(aEmp.getProductId() + ",");
			System.out.print(aEmp.getSellerId() + ",");
			System.out.print(aEmp.getName() + ",");
			System.out.print(aEmp.getCategoryId() + ",");
			System.out.print(aEmp.getDescription());
			System.out.print(aEmp.getReviewStatus() + ",");
			System.out.println();
		}
	}
}
