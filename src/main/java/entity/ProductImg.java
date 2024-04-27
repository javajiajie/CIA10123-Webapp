package entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.product.model.ProductVO;

@Entity
@Table(name = "general_product_image")
public class ProductImg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id", updatable = false)
	private Integer imageId;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "image")
	private Blob image;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "general_product", referencedColumnName = "productId")
	private ProductVO productVO;
	
	
	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public ProductVO getProductVO() {
		return productVO;
	}

	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}

	@Override
	public String toString() {
		return "ProductImg [imageId=" + imageId + ", productId=" + productId + ", image=" + image + "]";
	}
	
	
}
