package com.finalProject.demo.model.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
	
	//複合組件
	@Id
	@Column(name = "orderId")
	private Long orderId; 
	
	//產品代號
	@Column(name = "productId")
	private Long productId; 
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price")
	private Integer price;

	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	
}
