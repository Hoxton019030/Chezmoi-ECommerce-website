package com.finalProject.demo.model.entity.cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class Cart {

	//複合組件
	@Id
	@Column(name="memberId")
	private Long memberId;
	
	@Column(name = "productId")
	private String productId;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="total")
	private Integer total;

	
	public Cart() {
	}


	//getter/setter
	public Long getMemberId() {
		return memberId;
	}


	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}

	



}
