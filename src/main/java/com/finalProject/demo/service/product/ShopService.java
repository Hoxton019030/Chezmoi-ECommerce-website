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

import com.finalProject.demo.model.entity.cart.Cart;
import com.finalProject.demo.model.entity.order.OrderDetail;
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
	 * ProductsDetail按照Series找相對應的顏色、尺寸
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
		Optional<List<Products>> TopProductList = pDao.findProductByCategory(category);
		if (TopProductList.isPresent()) {
			return TopProductList.get();
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
		Pageable pgb = PageRequest.of(pageNumber - 1, 8, Sort.Direction.DESC, "updateTime");
		Page<Products> page = pDao.findAll(pgb);
		return page;
	}

	/*
	 * Products按頁數撈資料-for Index頁面
	 */
	public Page<OrderDetail> findByPageIndex(Integer pageNumber) {
		Pageable pgb1 = PageRequest.of(pageNumber - 1, 8, Sort.Direction.DESC, "productId");
		Page<OrderDetail> page1 =orderDetailRepository.findAll(pgb1);
		return page1;
	}

//取productId第一筆

}
