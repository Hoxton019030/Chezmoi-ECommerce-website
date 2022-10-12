package com.finalProject.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalProject.demo.model.Payment;
import com.finalProject.demo.model.PaymentDao;

@Transactional
@Service
public class PaymentService {

	@Autowired
	private PaymentDao pDao;
	
	public Payment insert(Payment payment) {
		return pDao.save(payment);
	}
	
	public List<Payment> findAllPayment(){
		return pDao.findAll();
	}
}
