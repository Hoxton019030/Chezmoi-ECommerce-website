package com.finalProject.demo.service.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalProject.demo.model.entity.cart.Cart;
import com.finalProject.demo.model.entity.cart.Collection;
import com.finalProject.demo.repository.cart.CollectionRepository;

@Transactional
@Service
public class CollectionService {

	@Autowired
	private CollectionRepository collectionRepository;
	
	public Collection insert(Collection collection){
		return collectionRepository.save(collection);
	}
	
	public Collection findById(Long id) {
		Optional<Collection> optional = collectionRepository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}
	
	public void deleteById(Long id) {
		collectionRepository.deleteById(id);
	}
	
	public List<Collection> findAllCart(){
		return collectionRepository.findAll();
	}
	
}
