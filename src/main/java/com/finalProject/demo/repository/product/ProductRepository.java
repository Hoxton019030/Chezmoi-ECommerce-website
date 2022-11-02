package com.finalProject.demo.repository.product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finalProject.demo.model.entity.product.Products;
public interface ProductRepository extends JpaRepository<Products, String> {

	//模糊查詢
	List<Products> findByProductIdContaining(String productId);

	List<Products> findByName(String name);
	List<Products> findByCategory(String category);
	List<Products> findByProductState(String productState);
	public List<Products> findByCategoryOrderByProductIdDesc(String category);
	// public List<Products> findFirstByOrderByCreatTimesDesc();
	@Query(value = "TOP 1 * FROM Products WHERE productId=:productId3", nativeQuery = true)
	public Products findTopByProductId(@Param("productId3") String productId);

	//update product(不能改name & price)
	@Modifying
	@Query(value = "UPDATE Products SET productId=:productId1, size=:size1,color=:color1 ,productState=:state1 WHERE productId=:id1",nativeQuery = true)
	public void updateById(
			@Param("productId1")String newId,
			@Param("size1")String size,
			@Param("color1")String color,
			@Param("state1")String state,
			@Param("id1")String oldId
	);

	//UPDATE STATE by id
	@Modifying
	@Query(value = "UPDATE Products SET productState=:state2 WHERE productId=:id2",nativeQuery = true)
	public void updateStateById(
			@Param("state2")String state,
			@Param("id2")String id
	);
//	@Query()
//	Optional<Products> findBySeriesOne(String series);

	/*
	for productdetail取尺寸、顏色用
	 */
	Optional<List<Products>> findBySeries(String series);

	Optional<List<Products>> findProductByCategory(String category);

	// public List<Products> findFirstByOrderByCreatTimesDesc();

	// 按照productName同樣商品名也只取一筆
//	@Query(value = "SELECT DISTINCT series,productName,price  FROM products", nativeQuery = true)
//	public List<Products> findDistinctBySeries();

//	@Query(value = "TOP 1 * FROM Products WHERE productId=:productId3", nativeQuery = true)
//	public Products findTopByProductId(@Param("productId3")String productId);
	
	//update price  by series
	@Modifying
	@Query(value="UPDATE Products SET price=:price2 WHERE series=:series2",nativeQuery = true)
	public void updateSeriesPrice(@Param("price2")Integer price,@Param("series2")String series);
	
	
	//update name by series
	@Modifying
	@Query(value="UPDATE Products SET productName=:name3 WHERE series=:series3",nativeQuery = true)
	public void updateSeriesName(@Param("name3")String name,@Param("series3")String series);

	//老師寫的testSeries
	@Query(value="select distinct productName, price,photoId, series from products", nativeQuery=true)
	public List<Map<String,Object>> testSeries();
	
}
