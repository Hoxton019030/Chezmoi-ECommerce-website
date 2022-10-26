package com.finalProject.demo.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finalProject.demo.model.entity.product.Products;

public interface ProductRepository extends JpaRepository<Products, String> {

	List<Products> findByName(String name);

	List<Products> findByCategory(String category);

	List<Products> findByProductState(String productState);

	public List<Products> findByCategoryOrderByProductIdDesc(String category);

	// public List<Products> findFirstByOrderByCreatTimesDesc();

	@Query(value = "TOP 1 * FROM Products WHERE productId=:productId3", nativeQuery = true)
	public Products findTopByProductId(@Param("productId3") String productId);

}
