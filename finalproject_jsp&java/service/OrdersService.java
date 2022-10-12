package com.finalProject.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalProject.demo.model.Orders;
import com.finalProject.demo.model.OrdersDao;

@Transactional
@Service
public class OrdersService {

	@Autowired
	private OrdersDao oDao;
	
	public Orders insert(Orders orders) {
		return oDao.save(orders);
	}
}
