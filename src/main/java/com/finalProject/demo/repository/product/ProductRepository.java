package com.finalProject.demo.repository.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finalProject.demo.model.entity.product.Products;

public interface ProductRepository extends JpaRepository<Products, String> {



	List<Products> findByName(String name);
	List<Products> findByCategory(String category);
	List<Products> findByProductState(String productState);
	public List<Products> findByCategoryOrderByProductIdDesc(String category);
	// public List<Products> findFirstByOrderByCreatTimesDesc();
	@Query(value = "TOP 1 * FROM Products WHERE productId=:productId3", nativeQuery = true)
	public Products findTopByProductId(@Param("productId3") String productId);

	//update product
	@Modifying
	@Query(value = "UPDATE Products SET productId=:productId1, size=:size1,color=:color1,price=:price1 WHERE productId=:id1",nativeQuery = true)
	public void updateById(
			@Param("productId1")String newId,
			@Param("size1")String size,
			@Param("color1")String color,
			@Param("price1")Integer price,
			@Param("id1")String oldId
	);
	
	Optional<List<Products>> findBySeries(String series);

	Optional<List<Products>> findProductByCategory(String category);

	// public List<Products> findFirstByOrderByCreatTimesDesc();

	// 按照productName同樣商品名也只取一筆
	@Query(value = "SELECT DISTINCT series,productName,price  FROM products", nativeQuery = true)
	public List<Products> findDistinctBySeries();

//	@Query(value = "TOP 1 * FROM Products WHERE productId=:productId3", nativeQuery = true)
//	public Products findTopByProductId(@Param("productId3")String productId);


}
