package com.finalProject.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalProject.demo.model.Payment;
import com.finalProject.demo.model.Shipping;
import com.finalProject.demo.model.ShippingDao;

@Transactional
@Service
public class ShippingService {

	@Autowired
	private ShippingDao sDao;
	
	public Shipping insert(Shipping shipping) {
		return sDao.save(shipping);
	}
	
	public List<Shipping> findAllShipping(){
		return sDao.findAll();
	}
}
