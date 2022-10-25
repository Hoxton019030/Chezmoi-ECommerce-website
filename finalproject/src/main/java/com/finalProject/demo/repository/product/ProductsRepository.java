package com.finalProject.demo.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.demo.model.entity.product.Products;

public interface ProductsRepository extends JpaRepository<Products, String> {

}
