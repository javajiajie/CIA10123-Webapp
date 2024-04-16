package com.product.model;

	import java.util.List;
	import java.util.Set;
	import com.product.model.ProductVO;
	
public class ProductService {

		private ProductDAO_interface dao;

		public ProductService() {
			dao = new ProductJDBCDAO();
		}

		public List<ProductVO> getAll() {
			return dao.getAll();
		}

		public ProductVO getOneProduct(Integer productId) {
			return dao.findByPrimaryKey(productId);
		}

		public ProductVO addProduct(String name, Integer sellerId, Integer categoryId, Integer price, Integer quantity, String description, Integer reviewStatus, Integer productStatus) {
			ProductVO productVO = new ProductVO();
			productVO.setName(name);
	        productVO.setSellerId(sellerId);
	        productVO.setCategoryId(categoryId);
	        productVO.setDescription(description);
	        productVO.setPrice(price);
	        productVO.setQuantity(quantity);
	        productVO.setReviewStatus(reviewStatus);
	        productVO.setProductStatus(productStatus);
	        dao.insert(productVO);
			return productVO;
		}
		public ProductVO updateProduct(Integer productId, String name, Integer sellerId, Integer categoryId, Integer price, Integer quantity, String description, Integer reviewStatus, Integer productStatus) {
			ProductVO productVO = new ProductVO();
			productVO.setProductId(productId);
			productVO.setName(name);
	        productVO.setSellerId(sellerId);
	        productVO.setCategoryId(categoryId);
	        productVO.setDescription(description);
	        productVO.setPrice(price);
	        productVO.setQuantity(quantity);
	        productVO.setReviewStatus(reviewStatus);
	        productVO.setProductStatus(productStatus);
	        dao.insert(productVO);
			return productVO;
		}
		
//		public Set<ProductVO> getProductsByProductId(Integer productId) {
//			return dao.getProductsByProductId(productId);
//		}

}
