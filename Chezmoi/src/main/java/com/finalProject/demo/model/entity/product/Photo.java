package com.finalProject.demo.model.entity.product;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Product_photo")
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "photoId" , unique = true, nullable = false)
	private Long photoId;
	

	//主要pic
	@Column(name = "mainPic",columnDefinition = "varbinary(MAX)")
	private byte[] mainProduct_pic;
	
	
	//試衣間pic
	@Column(name = "brandPic",columnDefinition = "varbinary(MAX)")
	private byte[] brand_pic;
	
	//detail商品敘述圖:含多圖
	@Column(name = "detailPic",columnDefinition = "varbinary(MAX)")
	private byte[] detail_pic;
	
	
	
	@OneToMany(mappedBy = "photo")
	private List<Products> productId;
	

	public Photo() {
	}
	
	
	
	//getter/setter

	public Long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}

	
	public byte[] getMainProduct_pic() {
		return mainProduct_pic;
	}

	public void setMainProduct_pic(byte[] mainProduct_pic) {
		this.mainProduct_pic = mainProduct_pic;
	}

	public byte[] getBrand_pic() {
		return brand_pic;
	}

	public void setBrand_pic(byte[] brand_pic) {
		this.brand_pic = brand_pic;
	}


	public byte[] getDetail_pic() {
		return detail_pic;
	}



	public void setDetail_pic(byte[] detail_pic) {
		this.detail_pic = detail_pic;
	}

}
