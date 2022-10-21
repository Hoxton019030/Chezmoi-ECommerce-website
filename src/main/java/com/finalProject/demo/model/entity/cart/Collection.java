package com.finalProject.demo.model.entity.cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Collection")
public class Collection {
	
	//複合組件
	@Id
	@Column(name="memberId")
	private Long memberId;
	
	@Column(name = "productId")
	private String productId;
	



	
	public Collection() {
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

	

	

}
