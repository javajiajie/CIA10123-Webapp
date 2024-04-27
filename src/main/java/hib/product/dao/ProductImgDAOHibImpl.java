package hib.product.dao;

import static util.Constants.PAGE_MAX_RESULT;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.ProductImg;
import util.HibernateUtil;

public class ProductImgDAOHibImpl implements ProductImgDAO {
	// SessionFactory 為 thread-safe，可宣告為屬性讓請求執行緒們共用
	private SessionFactory factory;

	public ProductImgDAOHibImpl() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
	// 以避免請求執行緒共用了同個 Session
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(ProductImg entity) {
		// 回傳給 service 剛新增成功的自增主鍵值
		return (Integer) getSession().save(entity);
	}

	@Override
	public int update(ProductImg entity) {
		try {
			getSession().update(entity);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int delete(Integer id) {
		ProductImg productImg = getSession().get(ProductImg.class, id);
		if (productImg != null) {
			getSession().delete(productImg);
			// 回傳給 service，1代表刪除成功
			return 1;
		} else {
			// 回傳給 service，-1代表刪除失敗
			return -1;
		}
	}

	@Override
	public ProductImg getById(Integer id) {
		return getSession().get(ProductImg.class, id);
	}

	@Override
	public List<ProductImg> getAll() {
		return getSession().createQuery("from general_product_image", ProductImg.class).list();
	}

	@Override
	public List<ProductImg> getByCompositeQuery(Map<String, String> map) {
		if (map.size() == 0)
			return getAll();

		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<ProductImg> criteria = builder.createQuery(ProductImg.class);
		Root<ProductImg> root = criteria.from(ProductImg.class);

		List<Predicate> predicates = new ArrayList<>();

		for (Map.Entry<String, String> row : map.entrySet()) {
			if ("productId".equals(row.getKey())) {
				predicates.add(builder.like(root.get("productId"), "%" + row.getValue() + "%"));
			}

			if ("image".equals(row.getKey())) {
				predicates.add(builder.equal(root.get("image"), row.getValue()));
			}
		}

		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		criteria.orderBy(builder.asc(root.get("imageId")));
		TypedQuery<ProductImg> query = getSession().createQuery(criteria);

		return query.getResultList();
	}

	@Override
	public List<ProductImg> getAll(int currentPage) {
		int first = (currentPage - 1) * PAGE_MAX_RESULT;  //當前頁面(1)-1 =索引直  PAGE_MAX_RESULT頁數  等於分頁的第一個頁數
		return getSession().createQuery("from general_product_image", ProductImg.class)
				.setFirstResult(first)
				.setMaxResults(PAGE_MAX_RESULT)
				.list();
	}

	@Override
	public long getTotal() {
		return getSession().createQuery("select count(*) from general_product_image", Long.class).uniqueResult();
	}

}
