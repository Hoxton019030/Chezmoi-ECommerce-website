package com.finalProject.demo.controller.back.orderManagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalProject.demo.model.entity.order.OrderDetail;
import com.finalProject.demo.model.entity.order.Orders;
import com.finalProject.demo.service.order.OrdersService;

@RestController("order")
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private OrdersService ordersService;

	@GetMapping("")
	public List<Orders> findAll() {
		
		return ordersService.findAllOrders();
	}
	
	@GetMapping("/{id}")
	public List<OrderDetail> findOrderDetail(@PathVariable("id") Long id) {
		
		return ordersService.findOrderDetail(id);
	}
	
	@PutMapping("")
	public String editShippingCode(@RequestBody Orders code) {
		return ordersService.editShippingCode(code.getOrderId(), code.getShippingCode());
	}

}
