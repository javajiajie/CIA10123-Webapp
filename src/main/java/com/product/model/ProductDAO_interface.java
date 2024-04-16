package com.product.model;

import java.util.*;

public interface ProductDAO_interface {
	public void insert(ProductVO productVO);
	public void update(ProductVO productVO);
	public ProductVO findByPrimaryKey(Integer productId);
	public List<ProductVO> getAll();
//	public Set<ProductVO> getProductsByProductId(Integer productId);

}
