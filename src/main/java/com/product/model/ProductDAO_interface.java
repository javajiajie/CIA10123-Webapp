package com.product.model;

import java.util.*;

public interface ProductDAO_interface {
	public void insert(ProductVO productVO);
	public void update(ProductVO productVO);
	public void remove(Integer product_id);
	public ProductVO indByPrimaryKey(Integer product_id);
	public List<ProductVO> getAll();

}
