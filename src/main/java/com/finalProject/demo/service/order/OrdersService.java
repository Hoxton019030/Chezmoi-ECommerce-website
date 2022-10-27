package com.finalProject.demo.service.order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.model.entity.order.OrderDetail;
import com.finalProject.demo.model.entity.order.Orders;
import com.finalProject.demo.repository.order.OrderDetailRepository;
import com.finalProject.demo.repository.order.OrdersRepository;

@Transactional
@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	public Orders insert(Orders orders) {
		Date date = new Date();
		 SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm");
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
	
	
	public List<Orders> findOrderByMember(Member member){
		return ordersRepository.findByMember(member);
	}
	
	public List<OrderDetail> findOrderDetail(Long id) {
		
		return orderDetailRepository.findByOrderId(id);
	}


	public String editShippingCode(Long orderId, String shippingCode) {
		int result = ordersRepository.updateShippingCodeById(orderId, shippingCode);
		
		
		return result > 0 ?"建立成功":"建立失敗";
	}
	
}
