package com.finalProject.demo.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.demo.model.entity.order.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}
