package com.finalProject.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalProject.demo.model.Coupon;
import com.finalProject.demo.model.CouponDao;

@Transactional
@Service
public class CouponService {

	@Autowired
	private CouponDao cDao;
	
	
	public Coupon findById(String couponCode) {
		Optional<Coupon> optional = cDao.findById(couponCode);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		Coupon emptyCoupon = new Coupon();
		emptyCoupon.setCouponName("沒有這個折扣碼");
		
		return emptyCoupon;
	}
	
	public List<Coupon> findAllCoupon(){
		return cDao.findAll();
	}
}
