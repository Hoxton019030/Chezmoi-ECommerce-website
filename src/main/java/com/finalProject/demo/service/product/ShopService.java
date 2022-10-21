package com.finalProject.demo.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalProject.demo.model.entity.product.Products;
import com.finalProject.demo.repository.product.ProductRepository;

@Transactional
@Service
public class ShopService {

	@Autowired
	private ProductRepository pDao;

//找ID
	public  Products findById(String productId) {
		Optional<Products> optional=pDao.findById(productId);
		if(optional.isPresent()) {
			return optional.get();
			}
		return null;
	}
//找全部的資料
	public List<Products> findAllProducts(){
		return pDao.findAll();
	}
//按頁數撈資料	
	public Page<Products>findByPage(Integer pageNumber){
		Pageable pgb=PageRequest.of(pageNumber-1, 100, Sort.Direction.DESC, "updateTime");
		Page<Products> page=pDao.findAll(pgb);
		return page;
	}

//找最新
//	public List<Products> findLatest() {
//		return pDao.findFirstByOrderByCreatTimesDesc();
//	}

//取productId第一筆
	
	
}
