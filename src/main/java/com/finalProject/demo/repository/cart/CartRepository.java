package com.finalProject.demo.repository.cart;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.demo.model.entity.cart.Cart;
import com.finalProject.demo.model.mutiKeys.CartTableMultiKeysClass;

public interface CartRepository extends JpaRepository<Cart, CartTableMultiKeysClass> {

	@Override Optional<com.finalProject.demo.model.entity.cart.Cart> findById(CartTableMultiKeysClass id);
	
	
}
