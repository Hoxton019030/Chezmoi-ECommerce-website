package com.finalProject.demo.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.demo.model.entity.order.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	public Coupon findFirstByOrderByCouponIdDesc();
	
	Coupon findByCouponCode(String couponCode);
	

}
