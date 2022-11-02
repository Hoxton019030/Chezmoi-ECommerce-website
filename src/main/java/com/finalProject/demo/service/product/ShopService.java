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
import com.finalProject.demo.repository.order.OrderDetailRepository;
import com.finalProject.demo.repository.product.ProductRepository;

@Transactional
@Service
public class ShopService {

	@Autowired
	private ProductRepository pDao;
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	/*
	 * Products找ID
	 */
	public Products findById(String productId) {
		Optional<Products> optional = pDao.findById(productId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	/*
	 * Products找series
	 */
//	public List<Products> findBySeries(String series) {
//		Optional<List<Products>> optional = pDao.findBySeries(series);
//		return optional.orElse(null);
//	}

	/*
	 * ProductsDetail按照Series List找相對應的顏色、尺寸
	 */
	public List<Products> findBySeries(String series) {
		Optional<List<Products>> productList = pDao.findBySeries(series);
		if (productList.isPresent()) {
			return productList.get();
		}
		return null;
	}

	/*
	 * 按分類找商品
	 */
	public List<Products> findProductByCategory(String category) {
		Optional<List<Products>> catProductList = pDao.findProductByCategory(category);
		if (catProductList.isPresent()) {
			return catProductList.get();
		}
		return null;
	}

	/*
	 * Products找全部的資料
	 */
	public List<Products> findAllProducts() {
		return pDao.findAll();
	}

	/*
	 * Products按頁數撈資料-for Shop頁面
	 */
	public Page<Products> findByPage(Integer pageNumber) {
		Pageable pgb = PageRequest.of(pageNumber - 1, 16, Sort.Direction.DESC, "updateTime");
		Page<Products> page = pDao.findAll(pgb);
		return page;
	}

	/*
	 * 找出熱銷商品-for Index頁面
	 */
//	public List<Object[]> findBestProduct() {
//		List<Object[]> best = orderDetailRepository.findBestProduct();
//		return best;
//	}

//取productId第一筆

}
