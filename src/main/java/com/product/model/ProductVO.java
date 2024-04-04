package com.product.model;

public class ProductVO implements java.io.Serializable {
	private Integer product_id;
	private Integer seller_id;
	private Integer category_id;
	private String name;
	private String description;
	private Integer price;
	private Integer quantity;
	private Byte review_status;
	private Byte product_status;
	
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Byte getReview_status() {
		return review_status;
	}
	public void setReview_status(Byte review_status) {
		this.review_status = review_status;
	}
	public Byte getProduct_status() {
		return product_status;
	}
	public void setProduct_status(Byte product_status) {
		this.product_status = product_status;
	}
	
	
}
