package com.product.model;

public class ProductVO implements java.io.Serializable {
	private Integer productId;
	private Integer sellerId;
	private Integer categoryId;
	private String name;
	private String description;
	private Integer price;
	private Integer quantity;
	private Byte reviewStatus;
	private Byte productStatus;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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
	public Byte getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(Byte reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public Byte getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Byte productStatus) {
		this.productStatus = productStatus;
	}
	
}
