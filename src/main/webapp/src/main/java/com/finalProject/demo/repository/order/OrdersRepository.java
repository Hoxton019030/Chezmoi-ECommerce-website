package com.finalProject.demo.repository.order;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.finalProject.demo.model.entity.member.Member;
import com.finalProject.demo.model.entity.order.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

	@Query(value = " select top 1 *from Orders order by orderId desc",nativeQuery = true)
	Orders findTopOrder();
	
	Orders findByMember(Member member);
	
	Optional<Orders> findByOrderId(Long orderId);
	
//	List<Orders> findByOrderDate(Date orderDate);
	
	List<Orders> findByOrderState(String orderState);
	
//	List<Orders> findByShippingCode(Long shippingCode);
	
//	List<Orders> findByCustomerId(Long customerId);
	
	List<Orders> findByTotal(Long total);
	

	
}
