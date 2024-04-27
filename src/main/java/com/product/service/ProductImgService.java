package com.product.service;

import java.util.List;
import java.util.Map;

import entity.ProductImg;

public interface ProductImgService {  //服務層，增刪改查表格
	
	ProductImg addproductImg(ProductImg productImg);
	
	ProductImg updateproductImg(ProductImg productImg);
	
	void deleteproductImg(Integer imageId);
	
	ProductImg getProductImgByImageId(Integer imageId);
	
	List<ProductImg> getAllProductImgs(int currentPage);  //當前頁碼
	
	int getPageTotal();
	
	List<ProductImg> getProductImgsByCompositeQuery(Map<String, String[]> map);

}
