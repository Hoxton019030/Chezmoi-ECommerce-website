package com.finalProject.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalProject.demo.model.Cart;
import com.finalProject.demo.model.CartDao;

@Transactional
@Service
public class CartService {

	@Autowired
	private CartDao cDao;
	
	public Cart insert(Cart cart) {
		return cDao.save(cart);
	}
	
	public Cart findById(Integer id) {
		Optional<Cart> optional = cDao.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}
	
	public void deleteById(Integer id) {
		cDao.deleteById(id);
	}
	
	public List<Cart> findAllCart(){
		return cDao.findAll();
	}
	
}
