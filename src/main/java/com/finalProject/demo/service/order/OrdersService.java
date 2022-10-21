package com.finalProject.demo.service.order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	//insert Order
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
	
	
	//find all orders
	public List<Orders> findAllOrders(){
		return ordersRepository.findAll();
	}
	
	
	//find by Id
	public Orders findBId(Long Id) {
		Optional<Orders> optional = ordersRepository.findById(Id);
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}
	
	//find top order
	public Orders findTopOrder(){
		return ordersRepository.findTopOrder();
	}
	
	//find by Member
	public Orders findOrderByMember(Member member){
		return ordersRepository.findByMember(member);
	}
	
	
	//find by orderState
	public List<Orders> findByOrderState(String orderState) {
		return ordersRepository.findByOrderState(orderState);
	}
	
	//find by page
		public Page<Orders> findByPage(Integer pageNumber) { 
			Pageable pageable = PageRequest.of(pageNumber-1, 10, Sort.Direction.DESC, "orderId");
			 return ordersRepository.findAll(pageable);	
		}
	
	//確認Order是否存在
//	public Boolean existsById(Long orderId) {
//		boolean exists = ordersRepository.existsById(orderId);
//		if(exists == true) {
//			return true;
//		}
//		return false;
//	}
	
	
	
}
