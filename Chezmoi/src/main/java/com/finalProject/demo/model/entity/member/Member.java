package com.finalProject.demo.model.entity.member;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.finalProject.demo.model.entity.cart.Cart;
import com.finalProject.demo.model.entity.cart.Collection;

@Entity
@Table(name = "Member")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "memberId", unique = true, nullable = false)
	private Long memberId;
	
	@Column(name = "memberName",nullable = false,columnDefinition ="nvarchar(10)" )
	private String memberName;
	
	@Column(name = "birthday",nullable = false,columnDefinition = "datetime")
	private Date birthday;
	
	@Column(name = "phone",nullable = false)
	private Integer phone;
	
	@Column(name = "email",nullable = false,columnDefinition = "nvarchar(50)")
	private String email;
	
	//日後需調整為不顯示真正密碼(並改成加鹽密碼)2022.10.12
	@Column(name ="password",nullable = false,columnDefinition = "nvarchar(50)")
	private String password;

	
	
	public Member() {
	}
	
	//getter/setter
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	} 

	
	
}
