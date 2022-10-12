package com.finalProject.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Shipping")
public class Shipping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="shippingId")
	private Integer shippingId;
	
	@Column(name="shippingWay")
	private String shippingWay;
	
	public Shipping() {
	}

	public Integer getShippingId() {
		return shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public String getShippingWay() {
		return shippingWay;
	}

	public void setShippingWay(String shippingWay) {
		this.shippingWay = shippingWay;
	}
}
