package com.finalProject.demo.repository.member;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.finalProject.demo.model.entity.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	
	//註冊
	@Query(value = "from Member where email = :email")
	public List<Member> findEmail(String email);
	
	//登入
	@Query(value = "from Member where email = :email and password = :password")
	public List<Member> findLogin(String email, String password);
	
	//忘記密碼
	@Query(value = "from Member where email = :email and phone = :phone")
	public Optional<Member> findPassword(String email, String phone);

	//顯示會員資料
	@Query(value = "from Member where email = :email and password = :password")
	public List<Member> viewUser(String email, String password);

	//修改會員資料
	@Query(value = "from Member where memberName = :memberName and birthday = :birthday  and phone = :phone and email = :email")
	public int updateUser(String memberName, String birthday, String phone, String email);
	
}
