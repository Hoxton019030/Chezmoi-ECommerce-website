package com.finalProject.demo.repository.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.demo.model.entity.order.OrderDetail;
import com.finalProject.demo.model.mutiKeys.OrderDetailTableMutiKeysClass;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailTableMutiKeysClass> {
	
	List<OrderDetail> findByOrderId(Long id);

}
