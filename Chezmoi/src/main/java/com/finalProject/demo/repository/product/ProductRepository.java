package com.finalProject.demo.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.demo.model.entity.product.Products;

public interface ProductRepository extends JpaRepository<Products, String> {
	
	

	List<Products> findByName(String name);
	
	List<Products> findByCategory(String category);
	
	List<Products> findByProductState(String productState);
	
	public List<Products> findByCategoryOrderByProductIdDesc(String category);

}
