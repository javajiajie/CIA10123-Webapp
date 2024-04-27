package hib.product.dao;

import java.util.List;
import java.util.Map;

import entity.ProductImg;

public interface ProductImgDAO {  //訪問層，增刪改查表格數據
	
	int insert(ProductImg entity);

	int update(ProductImg entity);
	
	int delete(Integer id);
	 
	ProductImg getById(Integer id);
	
	List<ProductImg> getAll();
	
	List<ProductImg> getByCompositeQuery(Map<String, String> map);  //複合查詢
	
	List<ProductImg> getAll(int currentPage);
	
	long getTotal();
}
