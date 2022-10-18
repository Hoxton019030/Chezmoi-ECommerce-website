//package com.finalProject.demo.model.entity.product;
//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "Product_Descript")
//public class DescriptText {   
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long descriptId;
//	
//	@Column(name = "text", columnDefinition = "nvarchar(MAX)")
//	private String text;
//
//	@OneToMany(mappedBy = "descriptText")
//	private List<Products> productId;
//
//	
//
//	public DescriptText() {
//		super();
//	}
//
//	public DescriptText(Long descriptId, String text, List<Products> productId) {
//		super();
//		this.descriptId = descriptId;
//		this.text = text;
//		this.productId = productId;
//	}
//	
//	//getter/setter
//	public Long getDescriptId() {
//		return descriptId;
//	}
//
//	public void setDescriptId(Long descriptId) {
//		this.descriptId = descriptId;
//	}
//
//	public String getText() {
//		return text;
//	}
//
//	public void setText(String text) {
//		this.text = text;
//	}
//
//	public List<Products> getProductId() {
//		return productId;
//	}
//
//	public void setProductId(List<Products> productId) {
//		this.productId = productId;
//	}
//
//}
