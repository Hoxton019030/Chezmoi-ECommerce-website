package com.finalProject.demo.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalProject.demo.model.entity.product.Products;
import com.finalProject.demo.repository.product.ProductsRepository;

@Transactional
@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productsRepository;
	
	public List<Products> findAllProducts(){
		return productsRepository.findAll();
	}
	
	public Products findById(String Id) {
		Optional<Products> optional = productsRepository.findById(Id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public void deleteById(String id) {
		productsRepository.deleteById(id);
	}
	
}
