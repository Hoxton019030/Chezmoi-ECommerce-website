package com.finalProject.demo.service.order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.model.entity.order.Orders;
import com.finalProject.demo.repository.order.OrdersRepository;

@Transactional
@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;
	
	public Orders insert(Orders orders) {
		Date date = new Date();
		 SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		 String orderDate = dateFormat.format(date);
		 Date orderDateTime = null;
		try {
			orderDateTime = dateFormat.parse(orderDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 orders.setOrderDate(orderDateTime);
		return ordersRepository.save(orders);
	}
	
	public List<Orders> findAllOrders(){
		return ordersRepository.findAll();
	}
	
	public Orders findBId(Long Id) {
		Optional<Orders> optional = ordersRepository.findById(Id);
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}
	
	public Orders findTopOrder(){
		return ordersRepository.findTopOrder();
	}
	
	
	public Orders findOrderByMember(Member member){
		return ordersRepository.findByMember(member);
	}
	
}
