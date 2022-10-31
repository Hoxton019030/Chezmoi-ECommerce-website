package com.finalProject.demo.repository.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finalProject.demo.model.entity.order.OrderDetail;
import com.finalProject.demo.model.entity.product.Products;
import com.finalProject.demo.model.mutiKeys.OrderDetailTableMutiKeysClass;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailTableMutiKeysClass> {
	
	List<OrderDetail> findByOrderId(Long id);
	
	@Query(value = "SELECT TOP 8 productId, SUM(quantity) FROM OrderDetail GROUP BY productId ORDER BY SUM(quantity) DESC", nativeQuery = true)
	public List<Object[]> findBestProduct();

}
