package com.finalProject.demo.service.product;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalProject.demo.model.entity.product.Photo;
import com.finalProject.demo.repository.product.PhotoRepository;

@Service
@Transactional
public class PhotoService {
	
	@Autowired
	PhotoRepository photoRespository;
	
	//add photo
	public Photo addPhoto(Photo photo) {
		return photoRespository.save(photo);
	}
	
	
	
}
